package com.bridgelap.hotalmanagement;

    import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

    public class HotelReservationSystem {

        public enum CustomerType{
            REGULAR_CUSTOMER, REWARD_CUSTOMER
        }
        Scanner scanner = new Scanner(System.in) ;
        Hotel hotel1,hotel2,hotel3;
        String checkInDate;
        long totalNumberOfDays,weekendDays,weekDays;
        String checkOutDate;
        List<Hotel> hotels = new ArrayList<>();

        void addHotel(){
            hotel1 = new Hotel("Lakewood",3,110,80,90,80);
            hotel2 = new Hotel("BridgeWood",4,150,110,50,50);
            hotel3 = new Hotel("RidgeWood",5,220,100,150,40);
            hotels.add(hotel1);
            hotels.add(hotel2);
            hotels.add(hotel3);
        }

        public boolean isDateValid(String date) {
            String regex = "^[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}$";
            return Pattern.matches(regex,date);
        }

        void enterDates(){
            do {
                System.out.println("Enter Check in Date in format (dd-m-yyyy)");
                checkInDate = scanner.nextLine();
            }while(!isDateValid(checkInDate));

            do{
                System.out.println("Enter Check out Date in format (dd-m-yyyy)");
                checkOutDate = scanner.nextLine();
            }while(!isDateValid(checkOutDate));

            LocalDate inDate = LocalDate.of(Integer.parseInt(checkInDate.substring(5,9)),Integer.parseInt(checkInDate.substring(3,4)),Integer.parseInt(checkInDate.substring(0,2)));
            LocalDate outDate = LocalDate.of(Integer.parseInt(checkOutDate.substring(5,9)),Integer.parseInt(checkOutDate.substring(3,4)),Integer.parseInt(checkOutDate.substring(0,2))).plusDays(1);

            totalNumberOfDays = ChronoUnit.DAYS.between(inDate,outDate);
            weekendDays = getNumberOfWeekendDays(inDate , outDate);
            weekDays = totalNumberOfDays - weekendDays;

        }


        void cheapestHotel(CustomerType customerType){
            enterDates();
            calculateCost(weekDays,weekendDays,customerType);
            hotels.sort(Comparator.comparing(Hotel::getTotalCost));
            long cheapRate = hotels.get(0).getTotalCost();
            hotels.stream().filter(x -> x.getTotalCost() <= cheapRate).forEach(System.out::println);
        }

        void bestRatedCheapHotel(CustomerType customerType){
            enterDates();
            calculateCost(weekDays,weekendDays,customerType);
            hotels.sort(Comparator.comparing(Hotel::getTotalCost));
            long cheapRate = hotels.get(0).getTotalCost();
            hotels.sort(Comparator.comparing(Hotel::getRating));
            long rate = hotels.get(0).getRating();
            hotels.stream().filter(x -> (x.getTotalCost() <= cheapRate) && (x.getRating() > rate)).forEach(System.out::println);
        }

        void bestRatedHotel(CustomerType customerType){
            enterDates();
            enterDates();
            calculateCost(weekDays,weekendDays,customerType);
            hotels.sort(Comparator.comparing(Hotel::getRating));
            int index = hotels.size();
            System.out.println(hotels.get(index - 1));
        }

        long getNumberOfWeekendDays(LocalDate checkInDate, LocalDate checkOutDate) {
            List<LocalDate> weekendDays = checkInDate.datesUntil(checkOutDate).filter(date -> {
                DayOfWeek day = date.getDayOfWeek();
                return (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
            }).toList();
            return weekendDays.size();
        }

        void calculateCost(long weekDays, long weekendDays, CustomerType customerType){
            if(CustomerType.REGULAR_CUSTOMER.equals(customerType)) {
                hotels.forEach(x -> x.setTotalCost(x.regularCustomerRate * weekDays + x.regularCustomerWeekendRate * weekendDays));
            }else if(CustomerType.REWARD_CUSTOMER.equals(customerType)){
                hotels.forEach(x -> x.setTotalCost(x.rewardCustomerRate * weekDays + x.rewardCustomerWeekendRate * weekendDays));
            }
        }

    }

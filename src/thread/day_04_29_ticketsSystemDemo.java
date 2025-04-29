package thread;

public class day_04_29_ticketsSystemDemo {

    private static final int TOTAL_TICKETS = 30;
    private static int remainingTickets = TOTAL_TICKETS;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        for (int i = 1; i <=4; i++ ){
            new Thread(new TicketsWindow(i)).start();
        }
    }

    static class TicketsWindow implements Runnable{
        private int windowNumber;

        public TicketsWindow(int windowNumber){
            this.windowNumber = windowNumber;
        }

        @Override
        public void run(){
            while (true) {
                synchronized(lock){
                    if (remainingTickets > 0) {
                        buyTicket();
                    }else {
                        System.out.println("票已售空");
                        break;
                    }
                }

                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void buyTicket(){
            remainingTickets--;
            System.out.println("从窗口" + windowNumber + "购买1张票" + "剩余" + remainingTickets);
        }
    }

    
}

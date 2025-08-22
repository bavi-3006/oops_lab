import java.util.*;

// Base Class (Encapsulation)
class BankAccount {
    protected String holderName;
    protected double balance;

    public BankAccount(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;git 
        System.out.println("✅ " + amount + " deposited. New Balance = " + balance);
    }

    // Polymorphic method
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("✅ " + amount + " withdrawn. Remaining Balance = " + balance);
        } else {
            System.out.println(" Insufficient balance!");
        }
    }
}

// Child Class: Savings Account (Inheritance + Overriding)
class SavingsAccount extends BankAccount {
    private double minBalance = 1000;

    public SavingsAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minBalance) {
            balance -= amount;
            System.out.println(" Withdrawn " + amount + ". Balance left: " + balance);
        } else {
            System.out.println(" Cannot withdraw! Minimum balance rule violated.");
        }
    }
}

// Child Class: Current Account
class CurrentAccount extends BankAccount {
    private double overdraftLimit = 2000;

    public CurrentAccount(String holderName, double balance) {
        super(holderName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(" Withdrawn " + amount + ". Balance left: " + balance);
        } else {
            System.out.println(" Overdraft limit exceeded!");
        }
    }
}

// Main Class
public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        System.out.println(" Welcome to Bank System (OOP Demo)");

        while (true) {
            System.out.println("\n1. Create Savings Account\n2. Create Current Account\n3. Deposit\n4. Withdraw\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String sName = sc.nextLine();
                        System.out.print("Enter Opening Balance: ");
                        double sBal = sc.nextDouble();
                        accounts.add(new SavingsAccount(sName, sBal));
                        System.out.println(" Savings Account created for " + sName);
                        break;

                    case 2:
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String cName = sc.nextLine();
                        System.out.print("Enter Opening Balance: ");
                        double cBal = sc.nextDouble();
                        accounts.add(new CurrentAccount(cName, cBal));
                        System.out.println("🎉 Current Account created for " + cName);
                        break;

                    case 3: // Deposit
                        if (accounts.isEmpty()) {
                            System.out.println(" No accounts available!");
                            break;
                        }
                        sc.nextLine();
                        System.out.print("Enter Account Holder Name: ");
                        String depName = sc.nextLine();
                        System.out.print("Enter Deposit Amount: ");
                        double dep = sc.nextDouble();

                        boolean foundD = false;
                        for (BankAccount acc : accounts) {
                            if (acc.holderName.equalsIgnoreCase(depName)) {
                                acc.deposit(dep);
                                foundD = true;
                                break;
                            }
                        }
                        if (!foundD) System.out.println(" Account not found!");
                        break;

                    case 4: // Withdraw
                        if (accounts.isEmpty()) {
                            System.out.println(" No accounts available!");
                            break;
                        }
                        sc.nextLine();
                        System.out.print("Enter Account Holder Name: ");
                        String witName = sc.nextLine();
                        System.out.print("Enter Withdraw Amount: ");
                        double wit = sc.nextDouble();

                        boolean foundW = false;
                        for (BankAccount acc : accounts) {
                            if (acc.holderName.equalsIgnoreCase(witName)) {
                                acc.withdraw(wit);
                                foundW = true;
                                break;
                            }
                        }
                        if (!foundW) System.out.println(" Account not found!");
                        break;

                    case 5:
                        System.out.println(" Thank you for banking with us!");
                        sc.close();
                        return;

                    default:
                        System.out.println(" Invalid choice! Try again.");
                }
            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
                sc.nextLine(); // clear buffer
            }
        }
    }
}

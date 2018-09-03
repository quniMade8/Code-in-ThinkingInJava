package parent.enumerated;

import parent.demo.Enums;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

class Mail {
    //The NO's lower the probability of random selection
    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }

    enum Scannability {UNSACNNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;
    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scannability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return Address: " + returnAddress;
    }

    //Generate test Mail:
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = net.mindview.util.Enums.random(GeneralDelivery.class);
        m.scannability = net.mindview.util.Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = net.mindview.util.Enums.random(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(int count) {
        return new Iterable<Mail>() {
            int n = count;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class PostOffice {
    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail mail) {
                switch (mail.scannability) {
                    case UNSACNNABLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail mail) {
                switch (mail.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail mail) {
                switch (mail.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + mail + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail mail);
    }

    static void handle(Mail mail) {
        for (MailHandler h : MailHandler.values())
            if (h.handle(mail))
                return;
        System.out.println(mail + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail x : Mail.generator(10)) {
            System.out.println(x.details());
            handle(x);
            System.out.println("*****");
        }
    }
}

class PostOfficeViaEnumMap {
    interface Operation {
        boolean handle(Mail mail);
    }

    enum MailHandlerViaEnumMap {
        GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, RETURN_TO_SENDER;
    }

    static EnumMap<MailHandlerViaEnumMap, Operation> commandList = new EnumMap<>(MailHandlerViaEnumMap.class);

    static {
        commandList.put(MailHandlerViaEnumMap.GENERAL_DELIVERY, new Operation() {
            @Override
            public boolean handle(Mail mail) {
                switch (mail.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + mail);
                        return true;
                    default:
                        return false;
                }
            }
        });
        commandList.put(MailHandlerViaEnumMap.MACHINE_SCAN, new Operation() {
            @Override
            public boolean handle(Mail mail) {
                switch (mail.scannability) {
                    case UNSACNNABLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " automatically");
                                return true;
                        }
                }
            }
        });
        commandList.put(MailHandlerViaEnumMap.VISUAL_INSPECTION, new Operation() {
            @Override
            public boolean handle(Mail mail) {
                switch (mail.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (mail.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + mail + " normally");
                                return true;
                        }
                }
            }
        });
        commandList.put(MailHandlerViaEnumMap.RETURN_TO_SENDER, new Operation() {
            @Override
            public boolean handle(Mail mail) {
                switch (mail.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + mail + " to sender");
                        return true;
                }
            }
        });
    }
}

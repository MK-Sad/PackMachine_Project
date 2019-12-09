package pl.martenn.jpaczkomaty.id;

import java.util.Date;

public class MyIDGenerator implements IdGenerator {
    private int myPackId = 0;
    private String myPackMachineName = "PCK";
    private int myPackMachineId = 0;
    private long myTransportId = System.currentTimeMillis();

    @Override
    public String getPackId() {
        return String.valueOf(myPackId++);
    }

    @Override
    public String getPackMachineId() {
        return myPackMachineName + myPackMachineId++;
    }

    @Override
    public String getTransportId() {
        return String.valueOf(new Date().getTime());
    }


//    private int myPackId = new Integer(myPackId.intValue() +1);
//
//    Integer.toString(myPackId);


}

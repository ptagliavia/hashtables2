package equals;

public class ComputerSpec
{
    private String cpu;
    private int memoryGB;
    private boolean dedicateGraphicsCard;
    private double clockSpeed;

    public ComputerSpec()
    {
        cpu = "Intel i9 9900K";
        memoryGB = 32;
        dedicateGraphicsCard = true;
        clockSpeed = 5.0;
    }

    public ComputerSpec(String cpu, int memoryGB, boolean dedicateGraphicsCard,
                        double clockSpeed)
    {
        this.cpu = cpu;
        this.memoryGB = memoryGB;
        this.dedicateGraphicsCard = dedicateGraphicsCard;
        this.clockSpeed = clockSpeed;
    }

    /**
     * Redefine how ComputerSpec objects are compared (no longer based
     * on memory addresses).
     *
     * @param obj the other object
     * @return true if the objects are "equivalent", otherwise returns false
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) //same memory address
        {
            return true;
        }
        else if (obj == null) //nothing is equal to null
        {
            return false;
        }
        else if (!this.getClass().equals(obj.getClass())) //same class?
        {
            return false;
        }

        //at this point, what do we know for sure is true????
        ComputerSpec other = (ComputerSpec) obj;

        //specs are the same with memory and graphics card
        //return this.memoryGB == other.memoryGB && this.dedicateGraphicsCard == other.dedicateGraphicsCard;

        //specs are the same if the CPU is the same
        return this.cpu.equals(other.cpu);
    }

    public String getCpu()
    {
        return cpu;
    }

    public int getMemoryGB()
    {
        return memoryGB;
    }

    public boolean isDedicateGraphicsCard()
    {
        return dedicateGraphicsCard;
    }

    public double getClockSpeed()
    {
        return clockSpeed;
    }
}

package equals;

public class Cat
{
    private int age;
    private String name;
    private boolean longHair;
    private int cuteLevel;
    private double adoptionFee;

    public Cat(int age, String name, boolean longHair)
    {
        this.age = age;
        this.name = name;
        this.longHair = longHair;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (age != cat.age) return false;
        if (longHair != cat.longHair) return false;
        if (cuteLevel != cat.cuteLevel) return false;
        if (Double.compare(cat.adoptionFee, adoptionFee) != 0) return false;
        if (name != null ? !name.equals(cat.name) : cat.name != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result;
        long temp;
        result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (longHair ? 1 : 0);
        result = 31 * result + cuteLevel;
        temp = Double.doubleToLongBits(adoptionFee);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

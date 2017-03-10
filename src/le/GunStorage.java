package le;

import numberlist.InvalidIndexException;
import numberlist.primitivelist.IntegerArrayList;

/**
 * This is the business class which holds data that will be implemented inside
 * the GUI
 *
 * @author Phuc Hong Le
 * @version 1 (01/17/2017)
 */
public class GunStorage {

    //fields
    private String gunCollectionName;
    private IntegerArrayList year = new IntegerArrayList();
    private IntegerArrayList cost = new IntegerArrayList();
    private IntegerArrayList id = new IntegerArrayList();
    private int index;
    private int count;

    /**
     * Default constructor
     *
     * @param gunCollectionName the name of the gun collection
     */
    public GunStorage(String gunCollectionName) {
        this.gunCollectionName = gunCollectionName;
    }

    public String getGunCollectionName() {
        return gunCollectionName;
    }

    public void setGunCollectionName(String gunCollectionName) {
        this.gunCollectionName = gunCollectionName;
    }

    public void add(int idValue, int yearValue, int costValue)
            throws InvalidIndexException {
        this.id.add(idValue);
        this.year.add(yearValue);
        this.cost.add(costValue);
        count++;
        
    }

    public void remove(int idValue, int yearValue, int costValue)
            throws InvalidIndexException {
        this.id.remove(idValue);
        this.year.remove(yearValue);
        this.cost.remove(costValue);
        count--;
    }

    public void removeAt(int index)
            throws InvalidIndexException {
        this.id.removeAt(index);
        this.year.removeAt(index);
        this.cost.removeAt(index);
        count--;
    }

    public void addAt(int idId, int idValue, int yearValue, int costValue)
            throws InvalidIndexException {
        this.id.add(index, idValue);
        this.year.add(index, yearValue);
        this.cost.add(index, costValue);
        count++;
    }

    public int findId(int Value) {
        return this.id.find(Value);
    }

    public int getYear(int index) throws InvalidIndexException {
        return (int) year.get(index);
    }

    public void setYear(IntegerArrayList year) {
        this.year = year;
    }

    public int getCost(int index) throws InvalidIndexException {
        return (int) cost.get(index);
    }

    public void setCost(IntegerArrayList cost) {
        this.cost = cost;
    }

    public int getId(int index) throws InvalidIndexException {
        return (int) id.get(index);
    }

    public void setId(IntegerArrayList id) {
        this.id = id;
    }

    public int getSize() {
        return count;
    }
    
    public int getIndex() {
        return index;
    }

}

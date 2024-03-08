package Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Model<T extends Model> {
    public List<T> items = new ArrayList<>();
    public abstract int getID();
    public Model(){
    }
    public List<T> getItems(){
        return  items;
    }

    public void addItem(T item){
        items.add(item);
    }

    public T findByID(int ID){
        for (T x : items){
            if(x.getID()==ID){
                return x;
            }
        }
        return null;
    }

    //findbyid return T

    //findbyid return list T

    //creatNextID
    public int createNextId(){
        int max = 0;
        for(T item:items) if(item.getID() > max) max = item.getID();
        return  max;
    }



}

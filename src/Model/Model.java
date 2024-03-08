package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Model<T extends Model> {
    public List<T> items = new ArrayList<>();
    public abstract int getID();
    public abstract void read();
    public abstract void updateFile();
    public Model(){
    }
    public List<T> getItems(){
        return  items;
    }
public  void setItems(List<T> items){this.items = items;}
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

    public int createNextId(){
        int max = 0;
        for(T item:items) if(item.getID() > max) max = item.getID();
        return  max+1;
    }

}

// Author: Chai Jia You

package entity;

import java.io.Serializable;
import adt.*;

public class Programme implements Serializable{
    private String name;
    private int duration;
    private JYListInterface<TutorialGroup> tutgrouplist = new JYArrayList<>();
    
    public Programme(){

    }
    
    public Programme(String name, int duration){
        this.name = name;
        this.duration = duration;
    }
    
    public Programme(String name, int duration, JYListInterface<TutorialGroup> tutgroup){
        this.name = name;
        this.duration = duration;
        this.tutgrouplist = tutgroup;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
    
    public JYListInterface<TutorialGroup> getTutorialGroup(){
        return tutgrouplist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public void setTutorialGroupList(JYListInterface<TutorialGroup> tutgroup)
    {
        this.tutgrouplist = tutgroup;
    }
    
    public void addTutorialGroup(TutorialGroup tut){
        tutgrouplist.add(tut);
    }
    
    public void removeTutorialGroup(TutorialGroup tut){
        tutgrouplist.remove(tutgrouplist.searchIndex(tut) + 1);
    }

    @Override
    public boolean equals(Object obj){
        return(this == obj);
    }
    
    @Override
    public String toString(){
        return String.format("%-40s %d years",name,duration);
    }
}

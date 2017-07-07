package javapvt.lesson19;

import java.util.*;

public class StaffCollection <T extends Person>{

    private HashMap<String, HashSet<T>> data = new HashMap<>();
    private T director;


    public T getDirector() {
        return director;
    }

    public void setDirector(T director) {
        this.director = director;
    }

    public void addDepartment(String departmentName) {
        data.put(departmentName, new HashSet<T>());
    }

    public void removeDepartment(String name) {
        data.remove(name);
    }

    public void hire(String department, T value){
        if (!data.containsKey(department)){
            addDepartment(department);
        }
        data.get(department).add(value);
    }

    public void fire(String department, T value){
        if (data.containsKey(department)) {
            data.get(department).remove(value);
        } else
            System.out.println("No such department");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Director: ").append(director.getName());

        Iterator iterator = data.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<String, HashSet<T>> department =
                    (HashMap.Entry<String, HashSet<T>>) iterator.next();
            builder.append("\n\'");
            builder.append(department.getKey()).append("\'\n");
            for (Person person: department.getValue()) {
                builder.append(person.getName()).append("\n");
            }
        }
        return builder.toString();
    }





}

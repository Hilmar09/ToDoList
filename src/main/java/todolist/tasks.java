package todolist;



public class tasks{
        private String name;
        public boolean completed;

        public tasks(String name, boolean completed){
                this.name = name;
                this.completed = completed;
        }
      
public String getName(){
        return name;
}
public boolean iscompleted(){
        return completed;
}
public void setcompleted(boolean completed){
        this.completed = completed;
      }

}

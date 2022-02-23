package zadatak15;

public class Tasks {

    String oib;
    String task_name;
    String desc;
    String type;
    String current_status;
    int complexity;
    String time_spent;
    String starting_date_time;
    String end_date_time;

    public Tasks(){

    }
    
    public Tasks(String oib, String task_name, String desc, String type, String current_status, int complexity,
            String time_spent, String starting_date_time, String end_date_time) {
        this.oib = oib;
        this.task_name = task_name;
        this.desc = desc;
        this.type = type;
        this.current_status = current_status;
        this.complexity = complexity;
        this.time_spent = time_spent;
        this.starting_date_time = starting_date_time;
        this.end_date_time = end_date_time;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public String getTime_spent() {
        return time_spent;
    }

    public void setTime_spent(String time_spent) {
        this.time_spent = time_spent;
    }

    public String getStarting_date_time() {
        return starting_date_time;
    }

    public void setStarting_date_time(String starting_date_time) {
        this.starting_date_time = starting_date_time;
    }

    public String getEnd_date_time() {
        return end_date_time;
    }

    public void setEnd_date_time(String end_date_time) {
        this.end_date_time = end_date_time;
    }
     
}

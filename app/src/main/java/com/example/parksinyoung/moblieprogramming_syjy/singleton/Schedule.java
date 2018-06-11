package com.example.parksinyoung.moblieprogramming_syjy.singleton;

public class Schedule {
    private String className;
    private String classRoom;
    private String classDay;
    private String classTime;
    private String authorUid;
//    private String monday[] = new String[7];
//    private String tuesday[] = new String[7];
//    private String wednesday[] = new String[7];
//    private String thursday[] = new String[7];
//    private String friday[] = new String[7];

    //    public Schedule() {
////        for (int i = 0; i < 7; i++) {
////            monday[i] = "";
////            tuesday[i] = "";
////            wednesday[i] = "";
////            thursday[i] = "";
////            friday[i] = "";
////
////        }
//    }
    public Schedule() {

    }

    public Schedule(String className, String classRoom, String classDay, String classTime) {
        this.className = className;
        this.classRoom = classRoom;
        this.classDay = classDay;
        this.classTime = classTime;
        this.authorUid = User.getInstance().getUid();
    }

    public void setAuthorUid(String authorUid) {
        this.authorUid = authorUid;
    }

    public String getClassName() {
        return className;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public String getClassDay() {
        return classDay;
    }

    public String getClassTime() {
        return classTime;
    }

    public String getAuthorUid() {
        return authorUid;
    }

    public static Schedule newSchedule(String className, String classRoom, String classDay, String classTime) {
        return new Schedule(className, classRoom, classDay, classTime);
    }


}

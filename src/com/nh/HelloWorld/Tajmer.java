package com.nh.HelloWorld;

public class Tajmer {
	
    private long czasStart, czasCząstkowy;
    private boolean odliczanieTrwa = false;

    public Tajmer() {
            //this.czasStart = System.nanoTime();
    }

    public Tajmer start() {
        this.czasStart = System.nanoTime();
        this.odliczanieTrwa = true;
        return this;
    }

    public Tajmer przywróć() {
        if(!this.odliczanieTrwa) {
                this.czasStart = System.nanoTime();
                this.odliczanieTrwa = true;
        }
        return this;
    }

    public void zawieś() {
        this.czasCząstkowy += System.nanoTime() - this.czasStart;
        this.odliczanieTrwa = false;
    }

    public long koniec() {
        if(this.odliczanieTrwa) this.czasCząstkowy += System.nanoTime() - this.czasStart;
        this.odliczanieTrwa = false;
        return this.czasCząstkowy;
    }

    public void koniec(String komunikat) {
        if(this.odliczanieTrwa) this.czasCząstkowy += System.nanoTime() - this.czasStart;
        this.odliczanieTrwa = false;
        long czasCałkowity = this.czasCząstkowy;
        if(komunikat.length()>0)
            System.out.println(komunikat + " " + String.format("%4.2f", (double)czasCałkowity/1000000) + "ms.");
        else
            System.out.println("Czas zmierzony: " + String.format("%4.2f", (double)czasCałkowity/1000000) + "ms.");
        this.czasCząstkowy = 0;
    }

}

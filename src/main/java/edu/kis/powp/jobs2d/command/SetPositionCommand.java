package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

public class SetPositionCommand implements DriverCommand {
    private int x;
    private int y;
    private Job2dDriver driver;

    SetPositionCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    SetPositionCommand(int x, int y, Job2dDriver driver) {
        this(x, y);
        this.driver = driver;
    }

    @Override
    public void setDriver(Job2dDriver driver) {
        this.driver = driver;
    }

    @Override
    public void execute() {
        if (this.driver == null) throw new NullPointerException("No driver provided");
        this.driver.setPosition(this.x, this.y);
    }

    @Override
    public void execute(Job2dDriver driver) {
        this.setDriver(driver);
        this.execute();
    }
}

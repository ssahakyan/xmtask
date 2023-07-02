package functional.stepdeinitions;

public abstract class CommonStepDefinition<T> {
    public abstract T init();

    public abstract T open();
}

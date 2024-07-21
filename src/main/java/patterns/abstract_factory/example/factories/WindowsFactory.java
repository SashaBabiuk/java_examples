package patterns.abstract_factory.example.factories;

import patterns.abstract_factory.example.buttons.Button;
import patterns.abstract_factory.example.buttons.WindowsButton;
import patterns.abstract_factory.example.checkboxes.Checkbox;
import patterns.abstract_factory.example.checkboxes.WindowsCheckbox;

/**
 * Each concrete factory extends basic factory and responsible for creating
 * products of a single variety.
 */
public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

package ua.lviv.iot.terminal_jdbc.view;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import ua.lviv.iot.terminal_jdbc.controller.AddressController;
import ua.lviv.iot.terminal_jdbc.controller.CityController;
import ua.lviv.iot.terminal_jdbc.controller.CountryController;
import ua.lviv.iot.terminal_jdbc.controller.ManufacturerController;
import ua.lviv.iot.terminal_jdbc.controller.RegionController;
import ua.lviv.iot.terminal_jdbc.controller.TerminalController;
import ua.lviv.iot.terminal_jdbc.controller.TerminalTypeController;
import ua.lviv.iot.terminal_jdbc.controller.implementation.AddressControllerImpl;
import ua.lviv.iot.terminal_jdbc.controller.implementation.CityControllerImpl;
import ua.lviv.iot.terminal_jdbc.controller.implementation.CountryControllerImpl;
import ua.lviv.iot.terminal_jdbc.controller.implementation.ManufacturerControllerImpl;
import ua.lviv.iot.terminal_jdbc.controller.implementation.RegionControllerImpl;
import ua.lviv.iot.terminal_jdbc.controller.implementation.TerminalControllerImpl;
import ua.lviv.iot.terminal_jdbc.controller.implementation.TerminalTypeControllerImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.AddressEntity;
import ua.lviv.iot.terminal_jdbc.model.entity.CityEntity;
import ua.lviv.iot.terminal_jdbc.model.entity.CountryEntity;
import ua.lviv.iot.terminal_jdbc.model.entity.ManufacturerEntity;
import ua.lviv.iot.terminal_jdbc.model.entity.RegionEntity;
import ua.lviv.iot.terminal_jdbc.model.entity.TerminalEntity;
import ua.lviv.iot.terminal_jdbc.model.entity.TerminalTypeEntity;

public class View {

  private static final String KEY_EXIT = "Q";

  private static final String ERROR_NO_SUCH_OPTION = "No such option found. Try again.";

  private static final String TEXT_SELECT_MENU_OPTION = "Please choose menu option: ";
  private static final String TEXT_GO_BACK = "Go back or quit";

  private static Scanner input;

  public View() {
    input = new Scanner(System.in);
  }

  public void show() {
    showTablesMenu();
  }

  private void showTablesMenu() {
    Map<String, String> tablesMenu = generateTablesMenu();
    Map<String, Printable> tablesMenuMethods = generateTablesMenuMethods();
    showMenuFromMaps(tablesMenu, tablesMenuMethods);
  }

  private Map<String, String> generateTablesMenu() {
    Map<String, String> tablesMenu = new LinkedHashMap<String, String>();
    tablesMenu.put("1", "Table: Country");
    tablesMenu.put("2", "Table: Region");
    tablesMenu.put("3", "Table: City");
    tablesMenu.put("4", "Table: Address");
    tablesMenu.put("5", "Table: Manufacturer");
    tablesMenu.put("6", "Table: Terminal type");
    tablesMenu.put("7", "Table: Terminal");
    tablesMenu.put("8", "Table: Sex");
    tablesMenu.put("9", "Table: Position");
    tablesMenu.put("10", "Table: Workman");
    tablesMenu.put("11", "Table: Service type");
    tablesMenu.put("12", "Table: Service");
    return tablesMenu;
  }

  private Map<String, Printable> generateTablesMenuMethods() {
    Map<String, Printable> tableMenuMethods = new LinkedHashMap<String, Printable>();
    tableMenuMethods.put("1", this::showCountryMenu);
    tableMenuMethods.put("2", this::showRegionMenu);
    tableMenuMethods.put("3", this::showCityMenu);
    tableMenuMethods.put("4", this::showAddressMenu);
    tableMenuMethods.put("5", this::showManufacturerMenu);
    tableMenuMethods.put("6", this::showTerminalTypeMenu);
    tableMenuMethods.put("7", this::showTerminalMenu);
//    tableMenuMethods.put("8", "Table: Sex");
//    tableMenuMethods.put("9", "Table: Position");
//    tableMenuMethods.put("10", "Table: Workman");
//    tableMenuMethods.put("11", "Table: Service type");
//    tableMenuMethods.put("12", "Table: Service");
    return tableMenuMethods;
  }

  private void showCountryMenu() {
    Map<String, String> menu = generateCountryMenu();
    Map<String, Printable> menuMethods = generateCountryMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showRegionMenu() {
    Map<String, String> menu = generateRegionMenu();
    Map<String, Printable> menuMethods = generateRegionMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showCityMenu() {
    Map<String, String> menu = generateCityMenu();
    Map<String, Printable> menuMethods = generateCityMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showAddressMenu() {
    Map<String, String> menu = generateAddressMenu();
    Map<String, Printable> menuMethods = generateAddressMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showManufacturerMenu() {
    Map<String, String> menu = generateManufacturerMenu();
    Map<String, Printable> menuMethods = generateManufacturerMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showTerminalTypeMenu() {
    Map<String, String> menu = generateTerminalTypeMenu();
    Map<String, Printable> menuMethods = generateTerminalTypeMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private void showTerminalMenu() {
    Map<String, String> menu = generateTerminalMenu();
    Map<String, Printable> menuMethods = generateTerminalMenuMethods();
    showMenuFromMaps(menu, menuMethods);
  }

  private Map<String, String> generateCountryMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all countries");
    menu.put("2", "Select country");
    menu.put("3", "Create country");
    menu.put("4", "Update country");
    menu.put("5", "Delete country");
    return menu;
  }

  private Map<String, Printable> generateCountryMenuMethods() {
    CountryController countryController = new CountryControllerImpl();
    Formatter<CountryEntity, Integer> formatter = new Formatter<>(CountryEntity.class);
    ViewOperations<CountryEntity, Integer> countryOperation = new ViewOperations<>(countryController, formatter,
        CountryEntity.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", countryOperation::findAll);
    menuMethods.put("2", countryOperation::findById);
    menuMethods.put("3", countryOperation::create);
    menuMethods.put("4", countryOperation::update);
    menuMethods.put("5", countryOperation::delete);
    return menuMethods;
  }

  private Map<String, String> generateRegionMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all regions");
    menu.put("2", "Select region");
    menu.put("3", "Create region");
    menu.put("4", "Update region");
    menu.put("5", "Delete region");
    return menu;
  }

  private Map<String, Printable> generateRegionMenuMethods() {
    RegionController regionController = new RegionControllerImpl();
    Formatter<RegionEntity, Integer> formatter = new Formatter<>(RegionEntity.class);
    ViewOperations<RegionEntity, Integer> regionOperation = new ViewOperations<>(regionController, formatter,
        RegionEntity.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", regionOperation::findAll);
    menuMethods.put("2", regionOperation::findById);
    menuMethods.put("3", regionOperation::create);
    menuMethods.put("4", regionOperation::update);
    menuMethods.put("5", regionOperation::delete);
    return menuMethods;
  }

  private Map<String, String> generateCityMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all cities");
    menu.put("2", "Select city");
    menu.put("3", "Create city");
    menu.put("4", "Update city");
    menu.put("5", "Delete city");
    return menu;
  }

  private Map<String, Printable> generateCityMenuMethods() {
    CityController cityController = new CityControllerImpl();
    Formatter<CityEntity, Integer> formatter = new Formatter<>(CityEntity.class);
    ViewOperations<CityEntity, Integer> cityOperation = new ViewOperations<>(cityController, formatter,
        CityEntity.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", cityOperation::findAll);
    menuMethods.put("2", cityOperation::findById);
    menuMethods.put("3", cityOperation::create);
    menuMethods.put("4", cityOperation::update);
    menuMethods.put("5", cityOperation::delete);
    return menuMethods;
  }

  private Map<String, String> generateAddressMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all addresses");
    menu.put("2", "Select address");
    menu.put("3", "Create address");
    menu.put("4", "Update address");
    menu.put("5", "Delete address");
    return menu;
  }

  private Map<String, Printable> generateAddressMenuMethods() {
    AddressController addressController = new AddressControllerImpl();
    Formatter<AddressEntity, Integer> formatter = new Formatter<>(AddressEntity.class);
    ViewOperations<AddressEntity, Integer> addressOperation = new ViewOperations<>(addressController, formatter,
        AddressEntity.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", addressOperation::findAll);
    menuMethods.put("2", addressOperation::findById);
    menuMethods.put("3", addressOperation::create);
    menuMethods.put("4", addressOperation::update);
    menuMethods.put("5", addressOperation::delete);
    return menuMethods;
  }

  private Map<String, String> generateManufacturerMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all manufacturers");
    menu.put("2", "Select manufacturer");
    menu.put("3", "Create manufacturer");
    menu.put("4", "Update manufacturer");
    menu.put("5", "Delete manufacturer");
    return menu;
  }

  private Map<String, Printable> generateManufacturerMenuMethods() {
    ManufacturerController manufacturerController = new ManufacturerControllerImpl();
    Formatter<ManufacturerEntity, Integer> formatter = new Formatter<>(ManufacturerEntity.class);
    ViewOperations<ManufacturerEntity, Integer> manufacturerOperation = new ViewOperations<>(manufacturerController,
        formatter, ManufacturerEntity.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", manufacturerOperation::findAll);
    menuMethods.put("2", manufacturerOperation::findById);
    menuMethods.put("3", manufacturerOperation::create);
    menuMethods.put("4", manufacturerOperation::update);
    menuMethods.put("5", manufacturerOperation::delete);
    return menuMethods;
  }

  private Map<String, String> generateTerminalTypeMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all terminal types");
    menu.put("2", "Select terminal type");
    menu.put("3", "Create terminal type");
    menu.put("4", "Update termnal type");
    menu.put("5", "Delete termina type");
    return menu;
  }

  private Map<String, Printable> generateTerminalTypeMenuMethods() {
    TerminalTypeController terminalTypeController = new TerminalTypeControllerImpl();
    Formatter<TerminalTypeEntity, Integer> formatter = new Formatter<>(TerminalTypeEntity.class);
    ViewOperations<TerminalTypeEntity, Integer> terminalTypeOperation = new ViewOperations<>(terminalTypeController,
        formatter, TerminalTypeEntity.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", terminalTypeOperation::findAll);
    menuMethods.put("2", terminalTypeOperation::findById);
    menuMethods.put("3", terminalTypeOperation::create);
    menuMethods.put("4", terminalTypeOperation::update);
    menuMethods.put("5", terminalTypeOperation::delete);
    return menuMethods;
  }

  private Map<String, String> generateTerminalMenu() {
    Map<String, String> menu = new LinkedHashMap<String, String>();
    menu.put("1", "Select all terminals");
    menu.put("2", "Select terminal");
    menu.put("3", "Create terminal");
    menu.put("4", "Update termnal");
    menu.put("5", "Delete termina");
    return menu;
  }

  private Map<String, Printable> generateTerminalMenuMethods() {
    TerminalController terminalController = new TerminalControllerImpl();
    Formatter<TerminalEntity, Integer> formatter = new Formatter<>(TerminalEntity.class);
    ViewOperations<TerminalEntity, Integer> terminalOperation = new ViewOperations<>(terminalController, formatter,
        TerminalEntity.class);

    Map<String, Printable> menuMethods = new LinkedHashMap<String, Printable>();
    menuMethods.put("1", terminalOperation::findAll);
    menuMethods.put("2", terminalOperation::findById);
    menuMethods.put("3", terminalOperation::create);
    menuMethods.put("4", terminalOperation::update);
    menuMethods.put("5", terminalOperation::delete);
    return menuMethods;
  }

  private void showMenuFromMaps(Map<String, String> keyName, Map<String, Printable> keyMethod) {
    String keyMenu;
    do {
      printMenu(keyName);
      System.out.println(TEXT_SELECT_MENU_OPTION);
      keyMenu = input.nextLine().toUpperCase();
      Printable method = keyMethod.get(keyMenu);
      if (method != null) {
        method.print();
      } else if (!keyMenu.equals(KEY_EXIT)) {
        System.out.println(ERROR_NO_SUCH_OPTION);
      }
    } while (!keyMenu.equals(KEY_EXIT));
  }

  private void printMenu(Map<String, String> keyName) {
    for (String key : keyName.keySet()) {
      System.out.format("%3s - %s\n", key, keyName.get(key));
    }
    System.out.format("%3s - %s\n", KEY_EXIT, TEXT_GO_BACK);
  }

}

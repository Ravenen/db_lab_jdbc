package ua.lviv.iot.terminal_jdbc.view;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import ua.lviv.iot.terminal_jdbc.controller.Controller;
import ua.lviv.iot.terminal_jdbc.controller.implementation.CountryControllerImpl;
import ua.lviv.iot.terminal_jdbc.model.entity.CountryEntity;

public class View {

  private static final String KEY_EXIT = "Q";
  private static final String ERROR_NO_SUCH_OPTION = "No such option found. Try again.";
  private static final String TEXT_SELECT_MENU_OPTION = "Please choose menu option:";
  private static final String TEXT_GO_BACK = "Go back or quit";

//  private Map<String, String> menu;
//  private Map<String, Map<String, Printable>> menuMethods;
//  private Map<String, Printable> menuMethods;
  private static Scanner input = new Scanner(System.in);

  public View() {
//    menu = new LinkedHashMap<String, String>();
//    menuMethods = new LinkedHashMap<String, Map<String,Printable>>();
//    menuMethods = new LinkedHashMap<String, Printable>();
//    menu.put("A", "Select all tables");
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
//    tableMenuMethods.put("2", this::showRegionMenu);
//    tableMenuMethods.put("3", this::showCityMenu);
    tableMenuMethods.put("4", this::showAddressMenu);
//    tableMenuMethods.put("5", "Table: Manufacturer");
//    tableMenuMethods.put("6", "Table: Terminal type");
//    tableMenuMethods.put("7", "Table: Terminal");
//    tableMenuMethods.put("8", "Table: Sex");
//    tableMenuMethods.put("9", "Table: Position");
//    tableMenuMethods.put("10", "Table: Workman");
//    tableMenuMethods.put("11", "Table: Service type");
//    tableMenuMethods.put("12", "Table: Service");
    return tableMenuMethods;
  }

  private void showCountryMenu() {
    Map<String, String> countryMenu = generateCountryMenu();
    Map<String, Printable> countryMenuMethods = generateCountryMenuMethods();
    showMenuFromMaps(countryMenu, countryMenuMethods);
  }

//  private void showRegionMenu() {
//    Map<String, String> regionMenu = generateRegionMenu();
//    Map<String, Printable> regionMenuMethods = generateRegionMenuMethods();
//    showMenuFromMaps(regionMenu, regionMenuMethods);
//  }
//  private void showCityMenu() {
//    Map<String, String> cityMenu = generateCityMenu();
//    Map<String, Printable> cityMenuMethods = generateCityMenuMethods();
//    showMenuFromMaps(cityMenu, cityMenuMethods);
//  }
  private void showAddressMenu() {
    System.out.println("Here is address menu");
  }

  private Map<String, String> generateCountryMenu() {
    Map<String, String> countryMenu = new LinkedHashMap<String, String>();
    countryMenu.put("1", "Select all countries");
    countryMenu.put("2", "Select country");
    countryMenu.put("3", "Create country");
    countryMenu.put("4", "Delete country");
    return countryMenu;
  }

  private Map<String, Printable> generateCountryMenuMethods() {
    Controller<CountryEntity, Integer> countryController = new CountryControllerImpl();
    Formatter<CountryEntity, Integer> formatter = new Formatter<>(CountryEntity.class);
    ViewOperations<CountryEntity, Integer> countryOperation = new ViewOperations<>(countryController, formatter);

    Map<String, Printable> countryMenuMethods = new LinkedHashMap<String, Printable>();
    countryMenuMethods.put("1", countryOperation::findAll);
    countryMenuMethods.put("2", countryOperation::findById);
    countryMenuMethods.put("3", this::createCountry);
    countryMenuMethods.put("4", this::deleteCountry);
    return countryMenuMethods;
  }

  private void createCountry() {
    System.out.println("Creating new country...");
  }

  private void deleteCountry() {
    System.out.println("Deleting country...");
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

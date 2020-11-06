package ua.lviv.iot.terminal_jdbc.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import ua.lviv.iot.terminal_jdbc.controller.Controller;

public class ViewOperations<T, K> {

  private static final String ERROR_NO_MATCHES_FOUND = "[Error] No matches found";
  private static final String ERROR_MESSAGE = "[Error] Message: ";
  private static final String ERROR_INVALID_ID = "[Error] Entered invalid id";
  private static final String ERROR_SQL = "[Error] Error while executing SQL";
  
  private static final String KEY_EXIT = "Q";
  private static final String TEXT_ENTER_ID = "Enter id or press '" + KEY_EXIT + "' to go back: ";

  private static Scanner input = new Scanner(System.in);

  private Controller<T, K> controller;
  private Formatter<T, K> formatter;

  public ViewOperations(Controller<T, K> controller, Formatter<T, K> formatter) {
    this.controller = controller;
    this.formatter = formatter;
  }

  public void findAll() {
    try {
      List<T> entities = controller.findAll();
      if (entities.size() > 0) {
        formatter.formatTable(entities);
      } else {
        System.out.println(ERROR_NO_MATCHES_FOUND);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void findById() {
    String keyMenu;
    do {
      System.out.println(TEXT_ENTER_ID);
      keyMenu = input.nextLine().toUpperCase();
      if (!keyMenu.equals(KEY_EXIT)) {
        try {
          Integer id = Integer.parseInt(keyMenu);
          @SuppressWarnings("unchecked")
          T foundEntity = controller.findById((K) id);
          if (foundEntity != null) {
            formatter.formatRow(foundEntity);
            break;
          } else {
            System.out.println(ERROR_NO_MATCHES_FOUND);
          }
        } catch (NumberFormatException e) {
          System.out.println(ERROR_INVALID_ID);
          System.out.println(ERROR_MESSAGE + e.getMessage());
        } catch (SQLException e) {
          System.out.println(ERROR_SQL);
          System.out.println(ERROR_MESSAGE + e.getMessage());
        }
      }

    } while (!keyMenu.equals(KEY_EXIT));
  }

}

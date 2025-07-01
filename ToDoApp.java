import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ToDoApp {
    // Declare global components
    private JFrame frame;
    private DefaultListModel<String> taskModel;
    private JList<String> taskList;
    private JTextField taskField;

    public ToDoApp() {
        // Frame setup
        frame = new JFrame("To-Do List App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        // Task list model
        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Scroll pane for task list
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Input field and buttons
        taskField = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        // Panel for input and buttons
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        inputPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add components to frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> addTask());
        deleteButton.addActionListener(e -> deleteTask());

        // Show the frame
        frame.setVisible(true);
    }

    // Add task to list
    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            taskModel.addElement(task);
            taskField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Task cannot be empty!");
        }
    }

    // Delete selected task
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(frame, "Please select a task to delete!");
        }
    }

    public static void main(String[] args) {
        // Run the app
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}

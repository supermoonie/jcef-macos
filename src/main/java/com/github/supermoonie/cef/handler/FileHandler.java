package com.github.supermoonie.cef.handler;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.callback.CefQueryCallback;
import org.cef.handler.CefMessageRouterHandlerAdapter;

import javax.swing.*;
import java.io.File;

/**
 * @author supermoonie
 * @since 2021/3/3
 */
public class FileHandler extends CefMessageRouterHandlerAdapter {

    private static final String FILE_SELECT = "file:select";

    private final JFrame owner;

    public FileHandler(JFrame owner) {
        this.owner = owner;
    }

    @Override
    public boolean onQuery(CefBrowser browser,
                           CefFrame frame,
                           long queryId,
                           String request,
                           boolean persistent,
                           CefQueryCallback callback) {
        if (FILE_SELECT.equals(request)) {
            SwingUtilities.invokeLater(() -> {
                JFileChooser fileChooser = new JFileChooser();
                Action details = fileChooser.getActionMap().get("viewTypeDetails");
                details.actionPerformed(null);
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(owner)) {
                    File selectedFile = fileChooser.getSelectedFile();
                    callback.success(selectedFile.getAbsolutePath());
                } else {
                    callback.failure(-1, "No Selected!");
                }
            });
            return true;
        }
        return false;
    }
}

package com.company.io;

import com.company.exceptions.InvalidFileNameException;
import com.company.exceptions.InvalidPathException;
import com.company.staticData.ExceptionMessages;
import com.company.staticData.SessionData;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class IOManager {
    public String traverseDirectory(int depth){
        LinkedList<File> subFolders = new LinkedList<>();
        String path = getCurrentDirectoryPath();
        int initialIndentation = path.split("\\\\").length;
        File root = new File(path);
        subFolders.add(root);

        while (subFolders.size() > 0){
            File currentFolder = subFolders.removeFirst();
            int currentIndentation = currentFolder.toString().split("\\\\").length - initialIndentation;
            if (depth - currentIndentation < 0){
                break;
            }
            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if (currentFolder.listFiles() != null){
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()){
                        subFolders.add(file);
                    } else {
                        int indexOfLastSlash = file.toString().lastIndexOf("\\");
                        for (int i = 0; i < indexOfLastSlash; i++) {
                             OutputWriter.writeMessage("-");
                        }
                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }

        }
        return path;
    }

    public void createDirectoryInCurrentFolder(String name){
        String path = getCurrentDirectoryPath() + "\\" + name;
        File file = new File(path);
        boolean wasDirMade = file.mkdir();
        if (!wasDirMade) {
            throw new InvalidFileNameException();
        }
    }

    public String getCurrentDirectoryPath() {
        return SessionData.currentPath;
    }

    public void changeCurrentDirRelativePath(String relativePath) throws IOException {
        if (relativePath.equals("..")){
            try {
                // go one directory up
                String currentPath = getCurrentDirectoryPath();
                int indexOfLastSlash = currentPath.lastIndexOf("\\");
                String newPath = currentPath.substring(0, indexOfLastSlash);
                changeCurrentDirAbsolutePath(newPath);
            } catch (StringIndexOutOfBoundsException ex){
                throw new StringIndexOutOfBoundsException(ExceptionMessages.INVALID_DESTINATION);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            // do to a given directory
            String currentPath = getCurrentDirectoryPath();
            currentPath += "\\" + relativePath;
            changeCurrentDirAbsolutePath(currentPath);
        }
    }

    public void changeCurrentDirAbsolutePath(String absolutePath) throws IOException {
        File file = new File(absolutePath);
        if (!file.exists()){
            throw new InvalidPathException();
        }

        SessionData.currentPath = absolutePath;
    }
}

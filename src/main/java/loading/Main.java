package loading;

import save.*;
import java.io.*;
import java.util.zip.*;

public class Main {
    public static void main(String[] args) {

        String path = "/home/nick/games/savegames/";
        // 1. Произвести распаковку архива в папке savegames.
        openZip(path + "zip.zip", path);

        // 2. Произвести считывание и десериализацию одного из разархивированных файлов save.dat
        File[] files = new File(path).listFiles();
        for (File file: files) {
            if(Save.getFileExtension(file).equals("dat")){
                GameProgress progress = openProgress(file.getPath());
                // 3. Вывести в консоль состояние сохранненой игры.
                System.out.println(progress.toString());
            }
        }
    }

    private static void openZip(String readPath, String savePath) {
        try(ZipInputStream zip = new ZipInputStream(new FileInputStream(readPath))){
            ZipEntry entry;
            String name;
            while ((entry = zip.getNextEntry()) != null){
               name = entry.getName();
                FileOutputStream stream = new FileOutputStream(savePath + name);
                for (int c = zip.read(); c != -1; c = zip.read()){
                    stream.write(c);
                }
                stream.flush();
                zip.closeEntry();
                stream.close();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
    }

    private static GameProgress openProgress(String savePath) {

        GameProgress progress = null;

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(savePath))){
            progress = (GameProgress) objectInputStream.readObject();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return progress;
    }
}

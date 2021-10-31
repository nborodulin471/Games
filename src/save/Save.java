package save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Save {

    private static String path = "/home/nick/games/savegames";

    public static void main(String[] args){

        // 1. Создать три экземпляра класса GameProgress.
        GameProgress save1 = new GameProgress(100, 1, 1, 0);
        GameProgress save2 = new GameProgress(80, 2, 2, 10);
        GameProgress save3 = new GameProgress(50, 6, 5, 20.5);

        // 2. Сохранить сериализованные объекты GameProgress в папку savegames из предыдущей задачи.
        saveGame(path + "/save1.dat", save1);
        saveGame(path + "/save2.dat", save2);
        saveGame(path+ "/save3.dat", save3);

        // 3. Созданные файлы сохранений из папки savegames запаковать в архив zip
        zipFiles(path + "/zip.zip", Arrays.asList("save1.dat", "save2.dat", "save3.dat"));

        // 4. Удалить файлы сохранений, лежащие вне архива.
        deleteSaveFiles();
    }

    private static void deleteSaveFiles() {
        File files = new File(path);
        if (files.isDirectory()){
            for (File file : files.listFiles()) {
                if(!getFileExtension(file).equals("zip")){
                    file.delete();
                }
            }
        }
    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    public static void saveGame(String path, GameProgress progress) {

        try (FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){;
            oos.writeObject(progress);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void zipFiles(String pathZip, List<String> listSave) {

        try (ZipOutputStream saveZip = new ZipOutputStream(new FileOutputStream(pathZip))) {
            for (String name : listSave) {
                try (FileInputStream inputStream = new FileInputStream(path + "/" + name)) {
                    ZipEntry entry = new ZipEntry(name);
                    saveZip.putNextEntry(entry);
                    byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    saveZip.write(buffer);
                    saveZip.closeEntry();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

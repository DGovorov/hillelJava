package IO;

import OOP.inheritance.hierarchy.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by User on 15.04.2016.
 */
public class IoMain {
    public static void main(String[] args) {
        //absoluteAndRelativePaths();

        //uglyPriorJava7Style();

        //tryWithResources();

        //copy();

        //readWithCodePage();

        //bufferedRead();

        //primitivesExample();

        //objectsExample();

        //propertiesExample();

        Person ivan = new Person("Ivan");
        Car myCar = new Car("BMW", 1985, ivan);
        ivan.setCar(myCar);
        myCar.setTenant(new Tenant("Nikolay"));

        save(myCar);

/************/

        Car deserializedCar = load();
        System.out.println(deserializedCar);
        // System.out.println(deserializedCar == myCar);



    }

    public static void  save(Car car){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("myFolder/car.dat"))){


            outputStream.writeObject(car);
            car.setTenant(new Tenant("Nikolai"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car load(){
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("myFolder/car.dat"))){
            return (Car) inputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void propertiesExample() {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("myFolder/settings.properties")) {
            properties.load(inputStream);
            String db = properties.getProperty("DB");
            int timeout = Integer.parseInt(properties.getProperty("timeout"));
            String password = properties.getProperty("password");


            System.out.println(db + " " + password + " " + timeout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void objectsExample() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("myFolder/object.dat"))) {
            int[] date = new int[]{15, 4, 2016};
            outputStream.writeObject(date);
            //outputStream.writeObject("Hello");
            //outputStream.writeObject(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("myFolder/object.dat"))){
            int[] date = (int[]) inputStream.readObject();
            System.out.println(Arrays.toString(date));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void primitivesExample() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("myFolder/primitives.dat"))) {
            dataOutputStream.writeInt(15);
            dataOutputStream.writeInt(4);
            dataOutputStream.writeInt(2016);
            dataOutputStream.writeLong(Long.MAX_VALUE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("myFolder/primitives.dat"))) {
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readInt());

            //System.out.println(dataInputStream.readInt()); //011111..
            //System.out.println(dataInputStream.readInt()); //111111..

            System.out.println(dataInputStream.readLong());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedRead() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("myFolder/myFile_copy.txt"), "windows-1251"))) {
            String value;
            while ((value = reader.readLine()) != null) {
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readWithCodePage() {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("myFolder/myFile_copy.txt"), "windows-1251")) {
            int value = 0;
            while ((value = reader.read()) != -1) {
                System.out.println((char) value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy() {
        try (InputStream inputStream = new FileInputStream("myFolder/myFile.txt");
             OutputStream outputStream = new FileOutputStream("myFolder/myFile_copy.txt")) {
            int value;
            while ((value = inputStream.read()) != -1) {
                outputStream.write(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tryWithResources() {
        try (InputStream inputStream = new FileInputStream("myFolder/myFile.txt")) {   //InputStream (Class) should implement Closable
            int value; // 0 to 255 (inputstream value, byte)
            while ((value = inputStream.read()) != -1) {
                System.out.print((char) value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void uglyPriorJava7Style() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("myFolder/myFile.txt");
            int value; // 0 to 255 (inputstream value, byte)
            while ((value = inputStream.read()) != -1) {
                System.out.print((char) value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void absoluteAndRelativePaths() {
        System.out.println("yes\\no");
        System.out.println("c:\\temp\\myFile.txt");
        System.out.println("/temp/myFile.txt");

        //File file = new File("c:\\temp\\MyFolder"); // win path
        File file = new File("/temp/MyFolder"); //linux path (absolute path starts with /)
        System.out.println(file.exists());
        file.mkdirs();
        System.out.println(file.exists());

        File relativeFile = new File("myFolder/myFile.txt"); //relative path, with no / at the beginning
        System.out.println(relativeFile.getAbsolutePath());

        // after jdk 7 (Path)
        Path relativePath = Paths.get("myFolder/myFile.txt"); //Paths are immutable!
        Path parent = relativePath.getParent();
        Path resolve = parent.resolve(relativePath);
        System.out.println(parent);
        System.out.println(resolve);

        Path absolutePath = relativePath.toAbsolutePath();
        System.out.println(absolutePath + ", is absolute: " + absolutePath.isAbsolute()); //path remains unchanged
        System.out.println(relativePath + " is relative: " + relativePath.isAbsolute());

        try {
            Files.createDirectories(relativePath.getParent());
            Files.createFile(relativePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void someMethodCaller() {
        someMethod(1, 3, 4, 2, 3);
    }

    public static void someMethod(Integer... integers) {
        System.out.println(integers[0]);
        System.out.println(integers[1]);
        System.out.println(integers[2]);
    }
}

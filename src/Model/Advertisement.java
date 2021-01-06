package Model;

import java.awt.*;
import java.io.File;

public class Advertisement {
    String ID;
    String content;
    File pictureFile;
    Image image;
    String serialNumber;


    @Override
    public String toString() {
        return "Advertisement{" +
                "ID='" + ID + '\'' +
                ", content='" + content + '\'' +
                ", pictureFile=" + pictureFile +
                ", image=" + image +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public File getPictureFile() {
        return pictureFile;
    }

    public void setPictureFile(File pictureFile) {
        this.pictureFile = pictureFile;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}

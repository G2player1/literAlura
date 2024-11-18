package Enos.SpringProject.literAlura.interfaces;

public interface IConvertData {
    <T> T getData(String json,Class<T> tclass);
}

package io.teamif.rpgstats.json;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.teamif.rpgstats.plugin.RPGStatsPlugin;
import lombok.SneakyThrows;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class JsonController {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().setVersion(1.0).create();

    /***
     * 객체를 Json파일로 저장해준다.
     *
     * @param object 저장 할 오브젝트
     * @param dataTitle 저장 할 파일의 이름
     */
    public static void SaveToJson(IJson object, String dataTitle) {
        if (!dataTitle.endsWith(".json"))
            dataTitle += ".json";
        File BaseDir = RPGStatsPlugin.instance.getDataFolder();
        try (FileWriter writer = new FileWriter(new File(BaseDir, dataTitle))) {
            gson.toJson(object, writer);
        } catch (IOException e) {
            final Logger logger = RPGStatsPlugin.instance.getLogger();
            logger.warning(String.format("Error occurred while saving Json file. FileName: %s", dataTitle));
            e.printStackTrace();
        }
    }

    /***
     * Json파일을 로드해 T로 반환
     *
     * @param target 로딩하고자 하는 클래스
     * @param <T> IJson이 상속되어 있는 클래스여야한다.
     * @return T에 해당하는 파일의 정보를 담아 T 객체로 받환한다.
     */
    public static <T extends IJson> T LoadJson(Class<T> target) {
        try {
            String dataTitle = (String) target.getDeclaredMethod("getFileName", String.class).invoke(null);
            if (!dataTitle.endsWith(".json"))
                dataTitle += ".json";
            File BaseDir = RPGStatsPlugin.instance.getDataFolder();
            try (FileReader reader = new FileReader(new File(BaseDir, dataTitle))) {
                return gson.fromJson(reader, (Type) target);
            } catch (IOException e) {
                final Logger logger = RPGStatsPlugin.instance.getLogger();
                logger.warning(String.format("Error occurred while loading Json file. FileName: %s", dataTitle));
                e.printStackTrace();
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException  ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

package scrap.mechanic.survival.modmanager.tools;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import scrap.mechanic.survival.modmanager.tools.entity.MyJSON;
import scrap.mechanic.survival.modmanager.tools.entity.MyJSONA;
import scrap.mechanic.survival.modmanager.tools.entity.MyJSONL;
import scrap.mechanic.survival.modmanager.tools.entity.MyJSONO;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONController {

    List<String> knownPrimaryKeys = new ArrayList<>();

    public JSONController() {
        knownPrimaryKeys.add("uuid");
        knownPrimaryKeys.add("itemId");
    }

    public void test() {
        String f1 = "C:\\Users\\Ich\\Desktop\\testfolder\\blocks.json",
                f1o = "C:\\Users\\Ich\\Desktop\\testfolder\\blocks_A.json",
                f2 = "C:\\Users\\Ich\\Desktop\\testfolder\\containers.json",
                f2o = "C:\\Users\\Ich\\Desktop\\testfolder\\containers_A.json",
                f3 = "C:\\Users\\Ich\\Desktop\\testfolder\\hideout.json",
                f3o = "C:\\Users\\Ich\\Desktop\\testfolder\\hideout_A.json",
                f4 = "C:\\Users\\Ich\\Desktop\\testfolder\\inventoryDescriptions.json",
                f4o = "C:\\Users\\Ich\\Desktop\\testfolder\\inventoryDescriptions_A.json",
                f5 = "C:\\Users\\Ich\\Desktop\\testfolder\\shapesets.json",
                f5o = "C:\\Users\\Ich\\Desktop\\testfolder\\shapesets_A.json";

        MyJSON mf1 = readJSONObjectFromFile(f1, "uuid");
        MyJSON mf1o = readJSONObjectFromFile(f1o, "uuid");
        MyJSON mf2 = readJSONObjectFromFile(f2, "uuid");
        MyJSON mf2o = readJSONObjectFromFile(f2o, "uuid");
        MyJSON mf3 = readJSONObjectFromFile(f3, "itemId");
        MyJSON mf3o = readJSONObjectFromFile(f3o, "itemId");
        MyJSON mf4 = readJSONObjectFromFile(f4, "name");
        MyJSON mf4o = readJSONObjectFromFile(f4o, "name");
        MyJSON mf5 = readJSONObjectFromFile(f5, "");
        MyJSON mf5o = readJSONObjectFromFile(f5o, "");

        writeJSONObjectToFile(merge(mf1, mf1o), "C:\\\\Users\\\\Ich\\\\Desktop\\\\testfolder\\\\blocks_result.json");
        writeJSONObjectToFile(merge(mf2, mf2o), "C:\\\\Users\\\\Ich\\\\Desktop\\\\testfolder\\\\containers_result.json");
        writeJSONObjectToFile(merge(mf3, mf3o), "C:\\\\Users\\\\Ich\\\\Desktop\\\\testfolder\\\\hideout_result.json");
        writeJSONObjectToFile(merge(mf4, mf4o), "C:\\\\Users\\\\Ich\\\\Desktop\\\\testfolder\\\\inventoryDescriptions_result.json");
        writeJSONObjectToFile(merge(mf5, mf5o), "C:\\\\Users\\\\Ich\\\\Desktop\\\\testfolder\\\\shapesets_result.json");

//        String f1 = "C:\\Users\\Ich\\Desktop\\testfolder\\testJO_1.json",
//                f1o = "C:\\Users\\Ich\\Desktop\\testfolder\\testJO_2.json",
//                f2 = "C:\\Users\\Ich\\Desktop\\testfolder\\testJA_1.json",
//                f2o = "C:\\Users\\Ich\\Desktop\\testfolder\\testJA_2.json",
//                f3 = "C:\\Users\\Ich\\Desktop\\testfolder\\shapesets.json",
//                f3o = "C:\\Users\\Ich\\Desktop\\testfolder\\shapesets_A.json";
//
//        MyJSON mf1 = readJSONObjectFromFile(f1, "uuid");
//        MyJSON mf1o = readJSONObjectFromFile(f1o, "uuid");
//        MyJSON mf2 = readJSONObjectFromFile(f2, "itemId");
//        MyJSON mf2o = readJSONObjectFromFile(f2o, "itemId");
//        MyJSON mf3 = readJSONObjectFromFile(f3, "");
//        MyJSON mf3o = readJSONObjectFromFile(f3o, "");
//
//        writeJSONObjectToFile(merge(mf1, mf1o), "C:\\Users\\Ich\\Desktop\\testfolder\\testJO_result.json");
//        writeJSONObjectToFile(merge(mf2, mf2o), "C:\\Users\\Ich\\Desktop\\testfolder\\testJA_result.json");
//        writeJSONObjectToFile(merge(mf3, mf3o), "C:\\Users\\Ich\\Desktop\\testfolder\\shapesets_result.json");
    }

    public void writeJSONObjectToFile(MyJSON json, String filePath) {
        try {
            File file = new File(filePath);
            if (json instanceof MyJSONO) {
                JSONObject jo = (JSONObject) json;
                Files.writeString(file.toPath(), jo.toString(3), StandardCharsets.UTF_8);
            }
            if (json instanceof MyJSONA) {
                JSONArray ja = (JSONArray) json;
                Files.writeString(file.toPath(), ja.toString(3), StandardCharsets.UTF_8);
            }
            if (json instanceof MyJSONL) {
                MyJSONL jl = (MyJSONL) json;
                Files.writeString(file.toPath(), jl.toJSONString(3), StandardCharsets.UTF_8);
            }
        } catch (IOException ex) {
            Logger.getLogger(JSONController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MyJSON readJSONObjectFromFile(String filepath, String primaryKey) {
        try {
            MyJSON result = null;
            File file = new File(filepath);
            String jsonString = Files.readString(file.toPath(), StandardCharsets.UTF_8);
            try {
                result = new MyJSONO(jsonString, primaryKey);
                return result;
            } catch (Exception ignore) {
            }
            try {
                result = new MyJSONA(jsonString, primaryKey);
                return result;
            } catch (Exception ignore) {
            }
            result = new MyJSONL(jsonString);
            return result;
        } catch (IOException ex) {
            Logger.getLogger(JSONController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public MyJSON merge(MyJSON json, MyJSON json2) {
        if (json instanceof MyJSONA) {
            return mergeArrayByID((MyJSONA) json, (MyJSONA) json2);
        }
        if (json instanceof MyJSONO) {
            return mergeObjectByID((MyJSONO) json, (MyJSONO) json2);
        }
        if (json instanceof MyJSONL) {
            return mergeJSONL((MyJSONL) json, (MyJSONL) json2);
        }
        return null;
    }

    private MyJSONO mergeObjectByID(MyJSONO jo1, MyJSONO jo2) {
        for (String key2 : jo2.keySet()) {
            boolean found = false;
            for (String key1 : jo1.keySet()) {
                if (key2.equals(key1)) {
                    found = true;
                    if (jo1.getPrimaryKey().equals("name")) {
                        jo1.put(key1, jo2.get(key1));
                    } else {
                        jo1.put(key1, mergeArrayByID(jo1.getJSONArray(key1), jo2.getJSONArray(key1), jo1.getPrimaryKey()));
                    }
                }
            }
            if (!found) {
                jo1.put(key2, jo2.get(key2));
            }
        }

        return jo1;
    }

    private MyJSONA mergeArrayByID(MyJSONA ja1, MyJSONA ja2) {
        System.err.println(ja1.toString());
        JSONArray a1 = new JSONArray(ja1.toString());
        JSONArray a2 = new JSONArray(ja2.toString());
        JSONArray r = mergeArrayByID(a1, a2, ja1.getPrimaryKey());
        MyJSONA result = new MyJSONA(r.toString(), ja1.getPrimaryKey());
        return result;
    }

    private JSONObject mergeObjectById(JSONObject jo1, JSONObject jo2, String id) {
        boolean found = false;
        for (String key2 : jo2.keySet()) {
            found = false;
            for (String key1 : jo1.keySet()) {
                if (key1.equals(key2)) {
                    found = true;
                    jo1.put(key1, jo2.get(key1));
                    break;
                }
            }
            if (!found) {
                jo1.put(key2, jo2.get(key2));
            }
        }
        return jo1;
    }

    private JSONArray mergeArrayByID(JSONArray ja1, JSONArray ja2, String id) {
        JSONObject jo1 = null, jo2 = null;
        JSONArray result = new JSONArray();
        Map<String, JSONObject> resultMap = new HashMap<>();
        for (Iterator it1 = ja1.iterator(); it1.hasNext();) {
            jo1 = (JSONObject) it1.next();
            resultMap.put(jo1.getString(id), jo1);
        }

        for (Iterator it2 = ja2.iterator(); it2.hasNext();) {
            jo2 = (JSONObject) it2.next();
            boolean found = false;
            for (Iterator it1 = ja1.iterator(); it1.hasNext();) {
                jo1 = (JSONObject) it1.next();
                if (jo1.get(id).equals(jo2.get(id))) {
                    found = true;
                    resultMap.put(jo1.getString(id), mergeObjectById(jo1, jo2, id));
                }
            }
            if (!found) {
                resultMap.put(jo2.getString(id), jo2);
            }
        }

        resultMap.keySet().forEach((key) -> {
            result.put(resultMap.get(key));
        });
        return result;
    }

    private MyJSONL mergeJSONL(MyJSONL json, MyJSONL json2) {
        for (String s2 : json2.getData()) {
            boolean found = false;
            for (String s1 : json.getData()) {
                if (s2.equals(s1)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                json.getData().add(s2);
            }
        }
        return json;
    }

    private boolean lineEquals(String s1, String s2) {
        return s1.replace(" ", "").equals(s2.replace(" ", ""));
    }

    private MyJSONO mergeByName(MyJSONO json, MyJSONO json2) {
        JSONObject result = new JSONObject();
        List<String> keysOfAdditional = new ArrayList<>();
        for (String key2 : json2.keySet()) {
            boolean found = false;
            for (String key1 : json.keySet()) {
                if (key1.equals(key2)) {
                    found = true;
                    result.put(key1, mergeJSONObject(json.getJSONObject(key1), json2.getJSONObject(key2)));
                }
            }
            if (!found) {
                keysOfAdditional.add(key2);
            }
        }
        for (String key2 : keysOfAdditional) {
            result.put(key2, json2.getJSONObject(key2));
        }
        return new MyJSONO(result, "name");
    }

    private JSONObject mergeJSONObject(JSONObject o1, JSONObject o2) {
        JSONObject result = new JSONObject();
        for (String key1 : o1.keySet()) {
            if (o2.get(key1) != null) {
                if (o1.get(key1) instanceof JSONObject) {
                    if (o2.get(key1) instanceof JSONObject) {
                        result.put(key1, mergeJSONObject(o1.getJSONObject(key1), o2.getJSONObject(key1)));
                    } else {
                        result.put(key1, o2.get(key1));
                    }
                } else if (o1.get(key1) instanceof JSONArray) {
                    if (o2.get(key1) instanceof JSONArray) {
                        result.put(key1, mergeJSONArray(o1.getJSONArray(key1), o2.getJSONArray(key1)));
                    } else {
                        result.put(key1, o2.get(key1));
                    }
                } else {
                    result.put(key1, o2.get(key1));
                }
            }
        }

        for (String key2 : o2.keySet()) {
            result.put(key2, o2.get(key2));
        }
        return result;
    }

    private JSONArray mergeJSONArray(JSONArray a1, JSONArray a2) {
        JSONArray result = new JSONArray();
        for (int i = 0; i < a1.length(); i++) {
            result.put(mergeJSONObject(a1.getJSONObject(i), a2.getJSONObject(i)));
        }
        return result;
    }

}

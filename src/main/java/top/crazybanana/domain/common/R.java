package top.crazybanana.domain.common;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
    private static final String _status = "status";
    private static final String _message = "message";
    private static final String _data = "data";

    private R(){
        put(_status, 200);
        put(_message, "成功");
    }

    public static R ok(){
        return new R();
    }

    public static R ok(Object data){
        R r = new R();
        r.put(_data, data);
        return r;
    }

    public static R error(Integer status, String message){
        R r = new R();
        r.put(_status, status);
        r.put(_message, message);
        return r;
    }
}

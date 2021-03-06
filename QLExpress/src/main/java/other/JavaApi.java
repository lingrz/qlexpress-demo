package other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ql.util.express.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangqi
 * @date 2019/1/28 下午4:57
 */

public class JavaApi {

    @Test
    public  void addClassMethod() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addClassMethod("firstOne",java.util.List.class, new Operator() {
            @Override
            public Object executeInner(Object[] list) throws Exception {
                ArrayList arrayList = (ArrayList) list[0];
                return arrayList.get(0);
            }
        });
        IExpressContext<String, Object> context =new DefaultContext<String, Object>();
        context.put("语文", 88);
        context.put("数学", 99);
        context.put("英语", 95);
        Object result = runner.execute("list=new ArrayList();list.add(1);list.add(5);list.add(4);return list.firstOne();",context,null,false,false);
        System.out.println(result);
    }

    @Test
    public void addClassField() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addClassField("firstOne",java.util.List.class, new Operator() {
            @Override
            public Object executeInner(Object[] list) throws Exception {
                ArrayList arrayList = (ArrayList) list[0];
                return arrayList.get(0);
            }
        });
        IExpressContext<String, Object> context =new DefaultContext<String, Object>();
        context.put("语文", 88);
        context.put("数学", 99);
        context.put("英语", 95);
        Object result = runner.execute("list=new ArrayList();list.add(1);list.add(5);list.add(4);return list.firstOne;",context,null,false,false);
        System.out.println(result);
    }


    @Test
    public void  getOutVarNames() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        String express = "a+b+c+d+e";
        String[] names = runner.getOutVarNames(express);
        for (String name:names){
            System.out.println(name);
        }
    }

    @Test
    public void getOutFunctionNames() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        String express = "a(m,n)+b(q,s)";
        String[] names = runner.getOutFunctionNames(express);
        for (String name:names){
            System.out.println(name);
        }
        System.out.println(runner.getInstructionSetFromLocalCache(express));

    }


    @Test
    public void testJson(){
        String json = "{\n"
            + "    \"status\": \"success\",\n"
            + "    \"result\": {\n"
            + "        [\n"
            + "            \"caseCode\": 112134,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ],\n"
            + "        [\n"
            + "            \"caseCode\": 112135,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ],\n"
            + "        [\n"
            + "            \"caseCode\": 112136,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ],\n"
            + "        [\n"
            + "            \"caseCode\": 112137,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ],\n"
            + "        [\n"
            + "            \"caseCode\": 112138,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ],\n"
            + "        [\n"
            + "            \"caseCode\": 112139,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ],\n"
            + "        [\n"
            + "            \"caseCode\": 112140,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ],\n"
            + "        [\n"
            + "            \"caseCode\": 112141,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ],\n"
            + "        [\n"
            + "            \"caseCode\": 112142,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ],\n"
            + "        [\n"
            + "            \"caseCode\": 112143,\n"
            + "            \"caseScore\": 0.46153846153846156\n"
            + "        ]\n"
            + "    },\n"
            + "    \"time\": 0.46288499999999977\n"
            + "}";
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("result");
        List<Map>  maps  = JSON.parseArray(jsonArray.toJSONString(),Map.class);

    }

    
}

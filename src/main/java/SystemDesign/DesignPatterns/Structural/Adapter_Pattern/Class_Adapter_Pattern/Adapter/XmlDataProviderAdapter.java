package SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Class_Adapter_Pattern.Adapter;


import SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Class_Adapter_Pattern.Adaptee.XmlDataProvider;
import SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Class_Adapter_Pattern.Main_Component.IReports;
import org.json.JSONObject;
import org.json.XML;

public class XmlDataProviderAdapter extends XmlDataProvider implements IReports {


    @Override
    public String getJsonData() {
        String xmlBody = getXmlData();

        if (xmlBody == null || xmlBody.isEmpty()) {
            throw new RuntimeException("Empty XML Body!");
        }

        JSONObject json = XML.toJSONObject(xmlBody);

        return json.toString(2);
    }

}

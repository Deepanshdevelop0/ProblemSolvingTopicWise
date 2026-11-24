package SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Object_Adapter_Pattern.Adapter;

import SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Object_Adapter_Pattern.Adaptee.XmlDataProvider;
import SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Object_Adapter_Pattern.Main_Component.IReports;
import org.json.JSONObject;
import org.json.XML;

public class XmlDataProviderAdapter extends IReports {

    private final XmlDataProvider provider;

    public XmlDataProviderAdapter(XmlDataProvider provider) {
        if (provider == null) {
            throw new IllegalArgumentException("XmlDataProvider cant be null");
        }
        this.provider = provider;
    }

    @Override
    public String getJsonData() {

        String xml = provider.getXmlData();

        if (xml == null || xml.isEmpty()) {
            throw new RuntimeException("Empty XML body!");
        }

        JSONObject json = XML.toJSONObject(xml);

        return json.toString(2);
    }

}

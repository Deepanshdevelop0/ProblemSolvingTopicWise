package SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Object_Adapter_Pattern;

import SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Object_Adapter_Pattern.Adaptee.XmlDataProvider;
import SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Object_Adapter_Pattern.Adapter.XmlDataProviderAdapter;
import SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Object_Adapter_Pattern.Main_Component.IReports;

public class Client {

    public static void main(String[] args) {
        IReports reports = new XmlDataProviderAdapter(new XmlDataProvider());

        String json = reports.getJsonData();

        System.out.println(json);
    }

}

package SystemDesign.DesignPatterns.Structural.Adapter_Pattern.Class_Adapter_Pattern.Adaptee;

public class XmlDataProvider {


    public String getXmlData() {
        return "<note id=\"101\">\n" +
                "  <to>Ali</to>\n" +
                "  <from>Sara</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Submit the report today.</body>\n" +
                "</note>";
    }

}

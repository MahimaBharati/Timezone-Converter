import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
public class Timezone implements ActionListener, Runnable
{
    JFrame jf;
    JLabel l1,l2,time1,label,label2;
    int hours,minutes,seconds;
    String timeString,target;
    JButton b1,reset;
    Thread t = null;
    
    JComboBox<String> select;
    Timezone()
    {
        l1 = new JLabel("Time Estimator");
        l1.setFont(l1.getFont().deriveFont(45.0f));
        Date dt = new Date();
        String[] countries = 
        {
            "Select",
            "Afghanisthan/Kabul",
        "India/Kolkata",
        "China/Bejing",
        "Japan/Tokyo",
        "Israel/Jerusalem",
        "England/London",
        "United States Of America",
        "Switzerland/Bern",
        "New Zealand/Wellington",
        "Russia/Moscow",
        "Turkey/Istanbul",
        "Iran/Tehran",
        "Sweden/Stockholm",
        "Netherlands/Amsterdam",
        "France/Paris",
        "Germany/Berlin",
        "Brazil/Brasilia",
        "Canada/Ottawa",
        "Italy/Rome",
        "Mexico/ Mexico City",
        "South Africa/Cape town",
        "Egypt/Cairo",
        "Vietnam/Hanoi",
        "Myanmar/Naypyitaw",
        "Indonesia/Jakarta",
        "Malaysia/Kuala Lumpur",
        "Singapore/Singapore",
        "Thailand/Bangkok"
    };
        t = new Thread(this);
        t.start();
        target="Select";
        Color val = new Color(36, 21, 195);
        l1.setSize(100, 100);
        l1.setForeground(val);
        l1.setBounds(205, 25, 450, 100);
        l2 = new JLabel("Select any Country:");
        l2.setFont(l2.getFont().deriveFont(20.0f));
        l2.setForeground(val);
        l2.setBounds(130, 200, 200, 40);
        label = new JLabel("Time in India is ");
        label.setFont(label.getFont().deriveFont(20.0f));
        label.setForeground(val);
        label.setBounds(100, 340, 300, 40);
        label2 = new JLabel();
        label2.setFont(label2.getFont().deriveFont(20.0f));
        label2.setForeground(val);
        label2.setBounds(100, 400, 650, 40);
        time1  = new JLabel();
        time1.setFont(time1.getFont().deriveFont(20.0f));
        time1.setForeground(val);
        time1.setBounds(250, 340, 400, 40);
        jf = new JFrame("Time Estimator");
        jf.setSize(800,600);
        jf.add(l1);
        b1=new JButton("Find Time");
        b1.setForeground(Color.white);
        b1.setBackground(val);
        b1.setBounds(210,270,130,30);
        b1.addActionListener(this);
        reset = new JButton("Reset");
        reset.setForeground(Color.white);
        reset.setBackground(val);
        reset.setBounds(360, 270, 130, 30);
        reset.addActionListener(this);
        select = new JComboBox<String>(countries);
        select.setBounds(370, 200, 200, 40);
        select.setForeground(val);
        jf.add(select);
        jf.add(label);
        jf.add(time1);
        jf.add(l2);
        jf.add(label2);
        jf.add(b1);
        jf.add(reset);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public void run() {  
      try {  
         while (true) {  
            Format formatter = new SimpleDateFormat("hh:mm:ss a      ||      dd-MM-yyyy");
            Date date = new Date();
            timeString = formatter.format( date );  
            time1.setText(timeString);
            if(target!="Select")
            label2.setText("Time in " + target + " is "+getTimeatZone(target));
            else
            label2.setText("");
            t.sleep(1000);  // interval given in milliseconds  
         }
         
      }
      catch (Exception e) {
      }
    }
    
    public static String getTimeatZone(String s1) {
        Instant instant = Instant.now();
        String res="";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss a      ||      dd-MM-yyyy");
        switch(s1)
        {
            case "India/Kolkata":
            ZonedDateTime IndiaTime = instant.atZone(ZoneId.of("Asia/Kolkata"));
            res=format.format(IndiaTime);
            break;

            case  "Japan/Tokyo":
            ZonedDateTime JpTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
            res=format.format(JpTime);
            break;

            case "United States Of America":
            ZonedDateTime AmericaTime = instant.atZone(ZoneId.of("America/Mexico_City"));
            res=format.format(AmericaTime);
            break;

            case "China/Bejing":
            ZonedDateTime ChinaTime = instant.atZone(ZoneId.of("Asia/Hong_Kong"));
            res = format.format(ChinaTime);
            break;
            case "Afghanisthan/Kabul":
            ZonedDateTime AfghanTime = instant.atZone(ZoneId.of("Asia/Tehran"));
            res =  format.format(AfghanTime);
            break;
            case "Israel/Jerusalem":
            ZonedDateTime IsraelTime = instant.atZone(ZoneId.of("Israel"));
            res= format.format(IsraelTime);
            break;
            case "England/London":
            ZonedDateTime EnglandTime = instant.atZone(ZoneId.of("Europe/London"));
            res= format.format(EnglandTime);
            break;
            case  "Switzerland/Bern":
            ZonedDateTime SwizzTime = instant.atZone(ZoneId.of("Europe/Dublin"));
            res= format.format(SwizzTime);
            break;

            case "New Zealand/Wellington":
            ZonedDateTime NewZealandTime = instant.atZone(ZoneId.of("NZ"));
            res=format.format(NewZealandTime);
            break;

            case "Russia/Moscow":
            ZonedDateTime RussianTime = instant.atZone(ZoneId.of("Europe/Moscow"));
            res= format.format(RussianTime);
            break;

            case "Turkey/Istanbul":
            ZonedDateTime TurkeyTime = instant.atZone(ZoneId.of("Turkey"));
            res=format.format(TurkeyTime);
            break;

            case  "Iran/Tehran":
            ZonedDateTime IranTime = instant.atZone(ZoneId.of("Iran"));
            res= format.format(IranTime);
            break;

            case "Sweden/Stockholm":
            ZonedDateTime SwedenTime = instant.atZone(ZoneId.of("Europe/Lisbon"));
            res= format.format(SwedenTime);
            break;

            case "Netherlands/Amsterdam":
            ZonedDateTime NetherTime = instant.atZone(ZoneId.of("Europe/Lisbon"));
            res= format.format(NetherTime);
            break;

            case  "France/Paris":
            ZonedDateTime FranceTime = instant.atZone(ZoneId.of("Europe/Paris"));
            res= format.format(FranceTime);
            break;

            case "Germany/Berlin":
            ZonedDateTime GermanTime = instant.atZone(ZoneId.of("Europe/Lisbon"));
            res= format.format(GermanTime);
            break;

            case  "Brazil/Brasilia":
            ZonedDateTime BrazilTime = instant.atZone(ZoneId.of("Brazil/East"));
            res= format.format(BrazilTime);
            break;

            case "Canada/Ottawa":
            ZonedDateTime CanadaTime = instant.atZone(ZoneId.of("Canada/Atlantic"));
            res=format.format(CanadaTime);
            break;

            case "Italy/Rome":
            ZonedDateTime ItalyTime = instant.atZone(ZoneId.of("Portugal"));
            res = format.format(ItalyTime);
            break;

            case "Mexico/ Mexico City":
            ZonedDateTime MexicoTime = instant.atZone(ZoneId.of("America/Mexico_City"));
            res= format.format(MexicoTime);
            break;

            case "South Africa/Cape town":
            ZonedDateTime SouthAfricaTime = instant.atZone(ZoneId.of("Europe/Stockholm"));
            res=format.format(SouthAfricaTime);
            break;

            case "Egypt/Cairo":
            ZonedDateTime EgyptTime = instant.atZone(ZoneId.of("Egypt"));
            res = format.format(EgyptTime);
            break;

            case "Vietnam/Hanoi":
            ZonedDateTime VietnamTime = instant.atZone(ZoneId.of("Asia/Vientiane"));
            res =  format.format(VietnamTime);
            break;

            case "Myanmar/Naypyitaw":
            ZonedDateTime MyanmarTime = instant.atZone(ZoneId.of("Asia/Rangoon"));
            res= format.format(MyanmarTime);
            break;

            case "Indonesia/Jakarta":
            ZonedDateTime IndonesiaTime = instant.atZone(ZoneId.of("Asia/Jakarta"));
            res = format.format(IndonesiaTime);
            break;

            case "Malaysia/Kuala Lumpur":
            ZonedDateTime MalaysiaTime = instant.atZone(ZoneId.of("Singapore"));
            res = format.format(MalaysiaTime);
            break;

            case "Singapore/Singapore":
            ZonedDateTime SingaporeTime = instant.atZone(ZoneId.of("Singapore"));
            res =  format.format(SingaporeTime);
            break;

            case "Thailand/Bangkok":
            ZonedDateTime ThailandTime = instant.atZone(ZoneId.of("Asia/Bangkok"));
            res =  format.format(ThailandTime);
            break;
        }
        return res;

    }
    public static void main(String[] args)
    {
       new Timezone();
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String s2 = select.getItemAt(select.getSelectedIndex());
            target=s2;
        }
        if (e.getSource() == reset) {
            target = "Select";
            select.setSelectedItem("Select");
        }
    }
    
}

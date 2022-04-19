/* The code was developed to retrieve randomness using twitter accounts. I have named this, "The Real-Time Pad" to honor the One-time pad, one of the most 
secure cryptographic algorithms but kept aside because of no unlimited source of randomness. This application generates both random characters as well as
bits and was tested using one of the security standards suggested by NSA". The code was well commented and please contact me if there are any questions*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

public class test  {

	
    public static void main(String[] args) throws Exception  {
    	
    	/*
    	 * Frame and its properties.
    	 */
        JFrame frame = new JFrame("The Real Time Pad");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = frame.getContentPane();
        SpringLayout layout=new SpringLayout();
        container.setLayout(layout);
        container.setBackground(Color.decode("#1dcaff"));
        
        /*
         * Elements required on the UI and their properties
         */
       
        URL url= test.class.getResource("trp.jpg");
        ImageIcon ic=new ImageIcon("trp.jpg");
        ImageIcon icon=new ImageIcon("icon.jpg");
        frame.setIconImage(icon.getImage());
        JLabel wallpaper=new JLabel(ic);
        wallpaper.setVisible(true);
        JTextField userinput = new JTextField();
        JButton GenerateButton = new JButton("Generate Random bits");
        GenerateButton.setBackground(Color.decode("#f9f983"));
        JButton CharButton=new JButton("Generate Random characters");
        CharButton.setBackground(Color.decode("#f9f983"));
        JLabel numberOfBits = new JLabel("Enter number of bits :");
        JLabel bitsare=new JLabel();
        JTextArea randomspace=new JTextArea();
        randomspace.setLineWrap(true);
        randomspace.setWrapStyleWord(true);
        randomspace.setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        randomspace.setBorder(BorderFactory.createCompoundBorder(border, 
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        wallpaper.setBorder(BorderFactory.createRaisedBevelBorder());
        GenerateButton.setBorder(BorderFactory.createRaisedBevelBorder());
        CharButton.setBorder(BorderFactory.createRaisedBevelBorder());
        randomspace.setEditable(false);
        JLabel zeros=new JLabel("Zeros: ");
        JLabel ones=new JLabel("Ones: ");
        JLabel zerocount=new JLabel("XXXX");
        JLabel onecount=new JLabel("XXXX");
        JLabel numbercharacters=new JLabel("Number of characters: ");
        JLabel numcharlen=new JLabel("XXXX");
        JLabel note=new JLabel("*For best results, please wait atleast 60Sec between each random set generation.");
        note.setForeground(Color.red);
        
        /*
         * Dimensions of the elements
         */
        userinput.setPreferredSize(new Dimension(100, 25));
        bitsare.setPreferredSize(new Dimension(200,50));
        randomspace.setPreferredSize(new Dimension(460,300));
        GenerateButton.setPreferredSize(new Dimension(220, 25));
        CharButton.setPreferredSize(new Dimension(220, 25));
        
        /*
         * Toggle tool tips
         */
        GenerateButton.setToolTipText("Click to generate random bits");
        userinput.setToolTipText("please enter valid integer");
        CharButton.setToolTipText("Click to generate random characters");
       
        /*
         * constraints for elements (used for positioning)
         */
        layout.putConstraint(SpringLayout.WEST, numberOfBits,
                10,
                SpringLayout.WEST, randomspace);
        layout.putConstraint(SpringLayout.SOUTH, wallpaper,
                -5,
                SpringLayout.NORTH, GenerateButton);
        layout.putConstraint(SpringLayout.WEST, wallpaper,
                0,
                SpringLayout.WEST, randomspace);
        layout.putConstraint(SpringLayout.EAST, wallpaper,
                0,
                SpringLayout.EAST, randomspace);
        layout.putConstraint(SpringLayout.NORTH, numberOfBits,
                15,
                SpringLayout.NORTH, container);
        layout.putConstraint(SpringLayout.WEST, userinput,
                20,
                SpringLayout.EAST, numberOfBits);
        layout.putConstraint(SpringLayout.NORTH, userinput,
                0,
                SpringLayout.NORTH, numberOfBits);
        layout.putConstraint(SpringLayout.NORTH, bitsare,
                0,
                SpringLayout.SOUTH, GenerateButton);
        layout.putConstraint(SpringLayout.WEST, bitsare,
                10,
                SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.NORTH, randomspace,
                0,
                SpringLayout.SOUTH, bitsare);
        layout.putConstraint(SpringLayout.WEST, randomspace,
                10,
                SpringLayout.WEST, container);
        layout.putConstraint(SpringLayout.WEST, CharButton,
                0,
                SpringLayout.WEST, randomspace);
        layout.putConstraint(SpringLayout.SOUTH, CharButton,
                0,
                SpringLayout.SOUTH, GenerateButton);
        layout.putConstraint(SpringLayout.NORTH, GenerateButton,
        		30,
        		SpringLayout.SOUTH, numberOfBits);
        layout.putConstraint(SpringLayout.EAST, GenerateButton,
                0,
                SpringLayout.EAST, randomspace);
        layout.putConstraint(SpringLayout.EAST, zeros,
                -3,
                SpringLayout.WEST, zerocount);
        layout.putConstraint(SpringLayout.NORTH, zeros,
                17,
                SpringLayout.SOUTH, GenerateButton);
        layout.putConstraint(SpringLayout.EAST, ones,
                -5,
                SpringLayout.WEST, onecount);
        layout.putConstraint(SpringLayout.NORTH, ones,
                17,
                SpringLayout.SOUTH, GenerateButton);
        layout.putConstraint(SpringLayout.EAST, onecount,
                0,
                SpringLayout.EAST, randomspace);
        layout.putConstraint(SpringLayout.NORTH, onecount,
                17,
                SpringLayout.SOUTH, GenerateButton);
        layout.putConstraint(SpringLayout.EAST, zerocount,
                -10,
                SpringLayout.WEST, ones);
        layout.putConstraint(SpringLayout.NORTH, zerocount,
                17,
                SpringLayout.SOUTH, GenerateButton);
        layout.putConstraint(SpringLayout.EAST, numcharlen,
                0,
                SpringLayout.EAST, randomspace);
        layout.putConstraint(SpringLayout.NORTH, numcharlen,
                17,
                SpringLayout.SOUTH, GenerateButton);
        layout.putConstraint(SpringLayout.NORTH, numbercharacters,
                17,
                SpringLayout.SOUTH, GenerateButton);
        layout.putConstraint(SpringLayout.EAST, numbercharacters,
                -5,
                SpringLayout.WEST, numcharlen);
        layout.putConstraint(SpringLayout.SOUTH, note,
                -5,
                SpringLayout.SOUTH, container);
        layout.putConstraint(SpringLayout.WEST, note,
                0,
                SpringLayout.WEST, randomspace);
       
        
        /*
         * Adding all elements to the frame and set initial visibility.
         */
        container.add(bitsare, SpringLayout.HORIZONTAL_CENTER);
        container.add(randomspace, SpringLayout.BASELINE);
        container.add(zeros);
        container.add(ones);
        container.add(wallpaper);
        container.add(GenerateButton,SpringLayout.SOUTH);
        container.add(CharButton);
        container.add(zerocount);
        container.add(onecount);
        container.add(numbercharacters);
        container.add(note);
        container.add(numcharlen);
        zeros.setVisible(false);
        zerocount.setVisible(false);
        ones.setVisible(false);
        onecount.setVisible(false);
        numcharlen.setVisible(false);
        numbercharacters.setVisible(false);
        
        /*
         * Mouse listener for the wallpaper to reset.
         * 
         */
        wallpaper.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                bitsare.setText("");
                numcharlen.setVisible(false);
                numbercharacters.setVisible(false);
                zeros.setVisible(false);
                zerocount.setVisible(false);
                ones.setVisible(false);
                onecount.setVisible(false);
                randomspace.setText("");
                
            }
        });
        
        /*
         * Action Listeners for buttons.
         */
        GenerateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                
                RealTimePad rtp=new RealTimePad();
                String input = rtp.generatekey();
                
                String k=rtp.getbitstring(input);
                String nozeros=rtp.getzerocount(k);
                String noones=rtp.getonecount(k);
                bitsare.setText("Your Random bits are: ");
                randomspace.setText(k);
                userinput.setText("");
                numcharlen.setVisible(false);
                numbercharacters.setVisible(false);
                zeros.setVisible(true);
                zerocount.setVisible(true);
                ones.setVisible(true);
                onecount.setVisible(true);
                zerocount.setText(nozeros);
                onecount.setText(noones);
               
            }
            
        });
        
        CharButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
                
                RealTimePad rtp=new RealTimePad();
                String input = rtp.generatekey();
                bitsare.setText("Your Random characters are: ");
                zeros.setVisible(false);
                zerocount.setVisible(false);
                ones.setVisible(false);
                onecount.setVisible(false);
                numcharlen.setVisible(true);
                numcharlen.setText(Integer.toString(input.length()));
                numbercharacters.setVisible(true);
                randomspace.setText(input);
               
            }
            
        });
        
        

        
        frame.setVisible(true);
    }

    
}

 class RealTimePad {

	 /*
	  * Generates the Random Key based on twitter data.
	  */
	public String generatekey() {
		
		/*
		 * Credentials for account 1 (Details hidden because of security issues).
		 */
		
		String consumerKey = "XXXXXX";
		String consumerSecret = "XXXXXX";
		String accessToken = "XXX-XXXX";
		String accessSecret = "XXXX";
		String key=null;
		
		/*
		 * Credentials for account 2 (Details hidden because of security issues).
		 */
		
		String anwesh_consumerKey = "XXXX";
		String anwesh_consumerSecret = "XXXXX";
		String anwesh_accessToken = "XXXX-XXXX";
		String anwesh_accessSecret = "XXXX";
		String anwesh_key=null;

		/*
		 * Configuration builders for accounts.
		 */
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret)
		.setOAuthAccessToken(accessToken)
		.setOAuthAccessTokenSecret(accessSecret);
		
		ConfigurationBuilder anwesh_builder = new ConfigurationBuilder();
		anwesh_builder.setDebugEnabled(true).setOAuthConsumerKey(anwesh_consumerKey)
		.setOAuthConsumerSecret(anwesh_consumerSecret)
		.setOAuthAccessToken(anwesh_accessToken)
		.setOAuthAccessTokenSecret(anwesh_accessSecret);
		
		
		        try {
		            /*
		             * gets Twitter instance with given credentials
		             */
		        	
		            Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		            Twitter anwesh_twitter=new TwitterFactory(anwesh_builder.build()).getInstance();
		            
		            /*
		             * Gets the statuses from the twitter accounts.
		             */
		            
		            List<Status> statuses = twitter.getHomeTimeline();
		            List<Status> anwesh_statuses=anwesh_twitter.getHomeTimeline();
		            
		           /*
		            * for every status thus obtained from account 1, generate a key.
		            */
		            
		            for (Status status : statuses) {
		            	
		            	String[] eachstatus=status.getText().split(" ");
		            	for(String s:eachstatus){
		            		if(s.startsWith("."))
		            		{
		            			continue;
		            		}
		            		if(s.contains("http"))
		            		{
		            			continue;
		            		}
		            		if(s.equalsIgnoreCase("the"))
		            		{
		            			continue;
		            		}
		            		if(s.equalsIgnoreCase("a"))
		            		{
		            			continue;
		            		}
		            		if(s.contains("retweeted"))
		            		{
		            			continue;
		            		}
		            		try{
		            			if(!s.isEmpty())
		            			{
		            		char cha=s.charAt(0);
		            		if( (cha >= 'a' && cha <= 'z') || (cha >= 'A' && cha <= 'Z')){
		            			if(key==null)
		            			{
		            			key =new String(Character.toString(cha));
		            			}
		            			else
		            			{
		            				key=key.concat(new String(Character.toString(cha)));
		            			}
				            	}
		            		}
		            		}
		            		catch(Exception e)
		            		{
		            			System.out.println(e.getMessage());
		            		}
		            	}
		            }
		           
		            /*
		             * for every status thus obtained from account 2, generate a random key.
		             */
		            
		            for (Status status : anwesh_statuses) {
		            	
		            	String[] anwesh_eachstatus=status.getText().split(" ");
		            	for(String s:anwesh_eachstatus){
		            		if(s.startsWith("."))
		            		{
		            			continue;
		            		}
		            		if(s.contains("http"))
		            		{
		            			continue;
		            		}
		            		if(s.equalsIgnoreCase("the"))
		            		{
		            			continue;
		            		}
		            		if(s.equalsIgnoreCase("a"))
		            		{
		            			continue;
		            		}
		            		if(s.contains("retweeted"))
		            		{
		            			continue;
		            		}
		            		try{
		            			if(!s.isEmpty())
		            			{
		            		char cha=s.charAt(0);
		            		if( (cha >= 'a' && cha <= 'z') || (cha >= 'A' && cha <= 'Z')){
		            			if(anwesh_key==null)
		            			{
		            				anwesh_key =new String(Character.toString(cha));
		            			}
		            			else
		            			{
		            				anwesh_key=anwesh_key.concat(new String(Character.toString(cha)));
		            			}
				            	}
		            		}
		            		}
		            		catch(Exception e)
		            		{
		            			System.out.println(e.getMessage());
		            		}
		            	}
		            }
		        } catch (TwitterException te) {
		            te.printStackTrace();
		            System.out.println("Failed to get timeline: " + te.getMessage());
		            System.exit(0);
		        }
		       
		        return mixstrings(key,anwesh_key);
		    }
	
	/*
	 * Takes a string as an input and returns a deskewed equivalent binary string.
	 */
	public  String getbitstring(String vamsi)
	{
		List<Character> string1=new ArrayList<Character>();
		List<Character> string2=new ArrayList<Character>();
		List<String> resultant=new ArrayList<String>();
		char vamsichars[]=vamsi.toCharArray();
		
		for(int i=0;i<vamsichars.length;i++)
		{
			if(i%2==0)
			string1.add(vamsichars[i]);
			else
				string2.add(vamsichars[i]);
				
		}
		for(int j=0;j<string1.size();j++)
		{
			resultant.add(characterDeskew(string1.get(j),string2.get(j)));
		}
		
		return listtostring(resultant);
	}
	
	/*
	 * returns number of '0's in a given string.
	 */
	public String getzerocount(String str)
	{
		
		int zerocount=0;
		char ar[]=str.toCharArray();
		for(char a: ar)
		{
			if(a=='0')
			{
				zerocount++;
			}
			else
				continue;
		}
		
		return Integer.toString(zerocount);
	}
	
	/*
	 * returns number of '1's in a given string.
	 */
	public String getonecount(String str)
	{
		
		int onecount=0;
		char ar[]=str.toCharArray();
		for(char a: ar)
		{
			if(a=='1')
			{
				onecount++;
			}
			else
				continue;
		}
		
		//System.out.println("ones count-->"+ onecount + " zero count-->"+zerocount);
		return Integer.toString(onecount);
	}
	
	/*
	 * Given two strings, combines the strings and returns the mixed string.
	 */
	public static String mixstrings(String a,String b)
	{
		if((a.length()==0)||(b.length()==0))
		{
			return null;
		}
		else
		{
		char achars[]=a.toCharArray();
		char bchars[]=b.toCharArray();
		List<String>mixed=new ArrayList<String>();
		int len=0;
		if(achars.length<bchars.length)
		{
			len=achars.length;
		}
		else
			len=bchars.length;
		for(int i=0;i<len;i++)
		{
			
				mixed.add(Character.toString(achars[i]));
				mixed.add(Character.toString(bchars[i]));
				
			
		}
		return listtostring(mixed);
		}
	}
	
	/*
	 * Takes two characters and returns a deskewed string.
	 * 
	 */
	public static String characterDeskew(char a, char b)
	{
		String a_bin=chartobinary(a);
		String b_bin=chartobinary(b);
		char achars[]=a_bin.toCharArray();
		char bchars[]=b_bin.toCharArray();
		int len=0;
		if(achars.length<=bchars.length)
		{
			len=achars.length;
		}
		else
			len=bchars.length;
		List<String> result=new ArrayList<String>();
		for(int i=0;i<len;i++)
		{
			result.add(deskew(Character.toString(achars[i]),Character.toString(bchars[i])));
		}
		
		
		return listtostring(result);
	}
	
	/*
	 * Deskews two bits and returns the resultant string.
	 * 
	 */
	public static String deskew(String value1,String value2)
	{
		if(value1.equalsIgnoreCase("0") && value2.equalsIgnoreCase("0"))
		{
			return new String(" ");
		}
		else if(value1.equalsIgnoreCase("1") && value2.equalsIgnoreCase("1"))
		{
			return new String(" ");
		}
		else if(value1.equalsIgnoreCase("0") && value2.equalsIgnoreCase("1"))
		{
			return new String("0");
		}
		else
		return new String ("1");
	}
	
	/*
	 * takes input a string. breaks it into characters. return a list of binary values for each character
	 */
	
		public static List<List<Integer>> stringtobinary(String f_string)
		{
			char stringchars[]=f_string.toCharArray();
			List<Integer> characterbinarylist = new ArrayList<Integer>();
			for(char ch : stringchars)
			{
				characterbinarylist.add(Integer.parseInt(chartobinary(ch)));
			}
			List<List<Integer>> stringbinaries=new ArrayList<List<Integer>>();
			
			for(int i:characterbinarylist)
			{
				stringbinaries.add(inttoarray(i));
			}
			return stringbinaries;
			
		}
		
		/*
		 * take input an integer value and breaks it into list of individual digits
		 */
		
		public static List<Integer> inttoarray(int integervalue)
		{
			
			List<Integer> intlist=new ArrayList<Integer>();	
			List<Integer> correctlist=new ArrayList<Integer>();	
				while(integervalue!=0)
				{
				intlist.add(integervalue%10);
				integervalue=integervalue/10;
				
				}
				for(int i=intlist.size()-1;i>=0;i--)
				{
					correctlist.add(intlist.get(i));
				}
			
			return correctlist;
		}
		
		/*
		 * take input a character and convert it into binary value string
		 */
		
		public static String chartobinary(char ch)
		{
			return Integer.toBinaryString((int)ch);
		}
		
		/*
		 *  take input a ascii value and convert it into binary value string
		 */
		public static String ascitobinary(int ascivalue)
		{
			return Integer.toBinaryString(ascivalue);
			
		}
		
		/*
		 * take a asci value and return associated character value
		 */
		public static char tochar(int ascivalue)
		{
			return (char)ascivalue;
		}
		/*
		 * converts a list of numbers into a single number by concatinating
		 */
		public static int listtoint(List<Integer> listint)
		{
			String intlist=new String();
			
			for(int i:listint)
			{
				intlist=intlist+Integer.toString(i);
			}
			return Integer.parseInt(intlist);
			
		}
		
		/*
		 * Given a list of strings, combines them into a single string.
		 */
		public static String listtostring(List<String> liststring)
		{
			String stringlist=new String();
			
			for(String i:liststring)
			{
				if(i.isEmpty()||i.startsWith(" "))
				{
					continue;
				}
				stringlist=stringlist+i;
			}
			return stringlist;
			
		}
		/*
		 * converts given character into associated asci value.
		 */
		
		public static int toascii(char ch)
		{
			return (int)ch;
		}
	}

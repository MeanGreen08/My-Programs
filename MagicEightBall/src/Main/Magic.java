package Main;

public class Magic {

	
	private String[] odp;
	
	
	Magic() {
	
	odp = new String[31];
	
	odp[0]= "As I see it, yes.";
	odp[1]= "Ask again later.";
	odp[2]= "Better not tell you now.";
	odp[3]= "Cannot predict now.";
	odp[4]= "Concentrate and ask again.";
	odp[5]= "Don’t count on it.";
	odp[6]= "It is certain.";
	odp[7]= "It is decidedly so.";
	odp[8]= "Most likely.";
	odp[9]= "My reply is no.";
	odp[10]= "My sources say no.";
	odp[11]= "Outlook good.";
	odp[12]= "Outlook not so good.";
	odp[13]= "Reply hazy try again.";
	odp[14]= "Signs point to yes.";
	odp[15]= "Very doubtful.";
	odp[16]= "Without a doubt.";
	odp[17]= "Yes.";
	odp[18]= "Yes, definitely.";
	odp[19]= "You may rely on it.";
	odp[20]= "Yes, but do it drunk as hell.";
	odp[21]= "Why do you ask me? I'm just a friggin 8-ball!" ;
	odp[22]= "Can't you figure that out yourself?";
	odp[23]= "I didn't catch that, speak louder and shake me again.";
	odp[24]= "Not you again..Ugh";
	odp[25]= "I don't know, ask the ouija board?";
	odp[26]= "As If";
	odp[27]= "Obviously";
	odp[28]= "Sure";
	odp[29]= "Oh Please";
	odp[30]= "You've got to be kidding...";
}
	
	
	
	
		String los() {	
			
		int x = (int)(Math.random()*(30)+1);

	    return odp[x];
	}
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


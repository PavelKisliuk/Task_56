import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Task_56 {
	public static void main(String[] args) {
		final String outputPath = "OUTPUT.TXT";
		final ListOfFriends test = new ListOfFriends();
		try(final BufferedWriter output = Files.newBufferedWriter(Paths.get(outputPath))) {
			output.write(test.toString());
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//-----------------------------------------------------------------------------
/*public*/ class ListOfFriends {
	//-----------------------------------------------------------------------------fields
	private ArrayList<String> friends;
	private ArrayList<String> mutualFriends;
	private ArrayList<String> alsoFriend;
	//-----------------------------------------------------------------------------constructors
	/*public*/ private ListOfFriends(final String path)
	{
		this.friends = new ArrayList<>();
		this.mutualFriends = new ArrayList<>();
		this.alsoFriend = new ArrayList<>();
		try(final BufferedReader input = Files.newBufferedReader(Paths.get(path))) {
			//-----------------------------------------------------------------------------
			if(input.ready()) {
				//-----------------------------------------------------------------------------
				int numbersOfFriends = Integer.valueOf(input.readLine()); //read data from file
				//-----------------------------------------------------------------------------
				for(int friend = 0; friend < numbersOfFriends; friend++) {
					this.friends.add(input.readLine()); //read data from file
				}
				Collections.sort(this.friends);
				//-----------------------------------------------------------------------------
				numbersOfFriends = Integer.valueOf(input.readLine()); //read data from file
				//-----------------------------------------------------------------------------
				for(int friend = 0; friend < numbersOfFriends; friend++) {
					String possibleFriend = input.readLine(); //read data from file
					if(this.friends.contains(possibleFriend)) {
						this.mutualFriends.add(possibleFriend);
					}
					else {
						this.alsoFriend.add(possibleFriend);
					}
				}
				Collections.sort(this.mutualFriends);
				Collections.sort(this.alsoFriend);
				//-----------------------------------------------------------------------------
			}
			//-----------------------------------------------------------------------------
			else {
				throw new IOException("File is empty!");
			}
			//-----------------------------------------------------------------------------
		}catch (IOException | NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/*public*/ ListOfFriends()
	{
		this("INPUT.TXT");
	}
	//-----------------------------------------------------------------------------
	//-----------------------------------------------------------------------------methods
	@Override
	public String toString()
	{
		return String.format("Friends: %s%nMutual Friends: %s%nAlso Friend of: %s",
				String.join(", ", this.friends),
				String.join(", ", this.mutualFriends),
				String.join(", ", this.alsoFriend));
	}
}
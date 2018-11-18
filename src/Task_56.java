import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Task_56 {
	public static void main(String[] args) {
		ListOfFriends test = new ListOfFriends();
		try(final Formatter output = new Formatter("OUTPUT.TXT")) {
			output.format(test.toString());
		}catch (FileNotFoundException | FormatterClosedException e) {
			e.printStackTrace();
		}
	}

	/*public*/ static class ListOfFriends {
		private ArrayList<String> friends;
		private ArrayList<String> mutualFriends;
		private ArrayList<String> alsoFriend;
		//-----------------------------------------------------------------------------
		public ListOfFriends(String path)
		{
			this.friends = new ArrayList<>();
			this.mutualFriends = new ArrayList<>();
			this.alsoFriend = new ArrayList<>();
			try(final Scanner input = new Scanner(Paths.get(path))) {
				//-----------------------------------------------------------------------------
				if(input.hasNext()) {
					//-----------------------------------------------------------------------------
					int numbersOfFriends = Integer.valueOf(input.nextLine()); //read data from file
					//-----------------------------------------------------------------------------
					for(int friend = 0; friend < numbersOfFriends; friend++) {
						this.friends.add(input.nextLine()); //read data from file
					}
					Collections.sort(this.friends);
					//-----------------------------------------------------------------------------
					numbersOfFriends = Integer.valueOf(input.nextLine()); //read data from file
					//-----------------------------------------------------------------------------
					for(int friend = 0; friend < numbersOfFriends; friend++) {
						String possibleFriend = input.nextLine(); //read data from file
						if(this.friends.contains(possibleFriend)) {
							this.mutualFriends.add(possibleFriend);
						}
						else {
							this.alsoFriend.add(possibleFriend);
						}
					}
					Collections.sort(this.mutualFriends);
					Collections.sort(this.alsoFriend);
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

		public ListOfFriends()
		{
			this("INPUT.TXT");
		}

		@Override
		public String toString()
		{
			return String.format("Friends: %s%nMutual Friends: %s%nAlso Friend of: %s",
					String.join(", ", this.friends),
					String.join(", ", this.mutualFriends),
					String.join(", ", this.alsoFriend));
		}
	}

}



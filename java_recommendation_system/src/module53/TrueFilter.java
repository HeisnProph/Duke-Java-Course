package module53;



public class TrueFilter implements Filter {

	private int num_rating;

	public TrueFilter(int i){
		num_rating = i;
	}

	@Override
	public boolean satisfies(String id) {

        double movie_rating = MovieDatabase.get_rating_number(id);

		return movie_rating>=num_rating;
	}

}

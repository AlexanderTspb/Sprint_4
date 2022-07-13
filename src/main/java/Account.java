public class Account {

    private final String name;
	private boolean isLengthCorrect;
	private boolean isOnlyOneSpace;
	private boolean isNotSpaceAtStartOrEnd;
	private boolean isNotBlank;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

		checkEmptyOrBlankIsName();
		checkNumberSpaces();
		checkStartsOrEndsWithSpace();
		checkLengthName();

		if(!isNotBlank || !isOnlyOneSpace || !isNotSpaceAtStartOrEnd || !isLengthCorrect){
			System.out.println("Имя некорректно");
			return false;
		}
		System.out.println("Имя корректно");
		return true;
    }

	//Метод на проверку пустого имени
	public void checkEmptyOrBlankIsName(){

		if(name.isEmpty() || name.isBlank()){
			System.out.println("Задано пустое имя");
			isNotBlank = false;
		}
		else{
			isNotBlank = true;
		}
	}

	//Метод на проверку количества пробелов
	public void checkNumberSpaces(){

		int numberSpaces = 0; // переменная-счётчик
        for (int i = 0; i < name.length(); i++) { // цикл
            if (name.charAt(i) == ' ') { // ориентируется на пробел
                numberSpaces++;
            }
        }
		if(numberSpaces > 1 || numberSpaces == 0){
			isOnlyOneSpace = false;
			System.out.println("Пробелов больше одного или нет");
		}
		else{
			isOnlyOneSpace = true;
		}

	}

	//Метод на проверку Начинается или заканчивается пробел
	public void checkStartsOrEndsWithSpace(){

		if(name.startsWith(" ") || name.endsWith(" ")){
			isNotSpaceAtStartOrEnd = false;
			System.out.println("Начинается или заканчивается на пробел");
		}else
		{
			isNotSpaceAtStartOrEnd  = true;
		}
	}

	//метод на проверку длины строки
	public void checkLengthName(){

		if(name.length() < 3 || name.length() > 19){
			isLengthCorrect = false;
			System.out.println("Недопустимая длина");
		}else
		{
			isLengthCorrect  = true;
		}
	}
} 

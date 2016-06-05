/**
 * Created by Jonas on 02-04-2016.
 */
interface Player {
    int getFaceValue();
    int getLocation();
    int getSquare(int oldLocation, int faceValue);
    void setLocation(int newLocation);
}

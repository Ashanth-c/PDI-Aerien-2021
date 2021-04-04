package data;

/*!
 * @file Position.java
 * @brief Classe qui décrit la position d'un point, définie par l'abscisse et l'ordonnée de ce point
 * @author Ashanth
 * @author Maeva
 * @author Khadija
 * @version 1.0
 * @date 06/04/2021
 */
public class Position {
	private float abscissa;
	private float ordinate;
/*!
 * Position()
 * 
 * @param abscissa Le coordonnee X de l'objet
 * @param ordinate Le coodonee Y de l'objet
 */
	public Position(float abscissa, float ordinate) {
		super();
		this.abscissa = abscissa;
		this.ordinate = ordinate;

	}
/*!
 * getAbscisse()
 * @brief retourne l'abscisse de la posision
 * @return abscisse Le coordonnee X de ll'objet
 */

	public float getAbscissa() {
		return abscissa;
	}
/*!
 * setAbscisse()
 * @brief changer l'abscisse de la posision
 * @param abscisse Le coordonnee X de ll'objet
 */

	public void setAbscissa(float abscissa) {
		this.abscissa = abscissa;
	}
/*!
 * getOrdonnee()
 * @brief retourne l'ordonnee de la position
 * @return ordinate Le coodonee Y de l'objet
 */

	public float getOrdinate() {
		return ordinate;
	}
/*!
 * setOrdonnee()
 * @brief changer l'ordonnee de la position
 * @param ordinate Le coodonee Y de l'objet
 */

	public void setOrdinate(float ordinate) {
		this.ordinate = ordinate;
	}
/*!
 * toString()
 * @return une chaine de caractère qui affiche la position avec l'abscisse et l'ordonnée
 */
	@Override
	public String toString() {
		return "Position [abscissa=" + abscissa + ", ordinate=" + ordinate + "]";
	}
}

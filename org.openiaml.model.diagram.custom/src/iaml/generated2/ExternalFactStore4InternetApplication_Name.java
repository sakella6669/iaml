package iaml.generated2;

/**
 * Class generated by the take compiler.
 * This class represents the external fact store factsInternetApplication_Name
 * for the predicate app_name
 * @version Wed Oct 15 15:05:06 NZDT 2008
 */
public interface ExternalFactStore4InternetApplication_Name {
    // Get all instances of this type from the fact store. 
    public nz.org.take.rt.ResourceIterator<iaml.generated2.InternetApplication_Name> fetch(
        org.openiaml.model.model.InternetApplication app,
        java.lang.String string);
}

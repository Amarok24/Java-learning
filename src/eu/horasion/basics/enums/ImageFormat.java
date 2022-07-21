package eu.horasion.basics.enums;

// Enums are by default: public static final.
// They can have attributes, methods and constructors similar to a class.
enum ImageFormat {

	// This is a special enum construct, bound to the enum's constructor.
	// This way we can add a longer description to each enum value.
	PNG("Portable Network Graphics"),
	WEBP("Web Picture"),
	JPEG("Joint Photographic Experts Group");

	private String imageFormatName;

	// Constructors in enum are *private* by default and are *not* instantiated.
	// This means we don't use them from outside, they just add features to enum.
	private ImageFormat(String imageFormatName) {
		this.imageFormatName = imageFormatName;
	}

	/**
	 * Returns the long description of an enum value.
	 */
	public String getImageFormatName() {
		return imageFormatName;
	}

	@Override
	public String toString() {
		return String.format("Format name: %s", imageFormatName);
	}

}

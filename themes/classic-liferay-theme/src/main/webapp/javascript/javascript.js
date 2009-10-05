jQuery(
	function() {
		if (Liferay.Browser.isIe() && Liferay.Browser.getMajorVersion() < 7) {
			jQuery('#navigation > ul > li').hover(
				function(event) {
					jQuery(this).addClass('hover');
				},
				function(event) {
					jQuery(this).removeClass('hover');
				}
			);
		}
	}
);
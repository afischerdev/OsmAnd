package net.osmand.plus.settings.backend;

import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceDataStore;

public class OsmAndPreferencesDataStore extends PreferenceDataStore {

	private OsmandSettings osmandSettings;
	private ApplicationMode appMode;

	public OsmAndPreferencesDataStore(OsmandSettings osmandSettings, @NonNull ApplicationMode appMode) {
		this.osmandSettings = osmandSettings;
		this.appMode = appMode;
	}

	@Override
	public void putString(String key, @Nullable String value) {
		osmandSettings.setPreference(key, value, appMode);
	}

	@Override
	public void putStringSet(String key, @Nullable Set<String> values) {
		osmandSettings.setPreference(key, values, appMode);
	}

	@Override
	public void putInt(String key, int value) {
		osmandSettings.setPreference(key, value, appMode);
	}

	@Override
	public void putLong(String key, long value) {
		osmandSettings.setPreference(key, value, appMode);
	}

	@Override
	public void putFloat(String key, float value) {
		osmandSettings.setPreference(key, value, appMode);
	}

	@Override
	public void putBoolean(String key, boolean value) {
		osmandSettings.setPreference(key, value, appMode);
	}

	public void putValue(String key, Object value) {
		osmandSettings.setPreference(key, value, appMode);
	}

	@Nullable
	@Override
	public String getString(String key, @Nullable String defValue) {
		OsmandPreference<?> preference = osmandSettings.getPreference(key);
		if (preference instanceof StringPreference) {
			return ((StringPreference) preference).getModeValue(appMode);
		} else {
			Object value = preference.getModeValue(appMode);
			if (value != null) {
				return value.toString();
			}
		}
		return defValue;
	}

	@Nullable
	@Override
	public Set<String> getStringSet(String key, @Nullable Set<String> defValues) {
		return super.getStringSet(key, defValues);
	}

	@Override
	public int getInt(String key, int defValue) {
		OsmandPreference<?> preference = osmandSettings.getPreference(key);
		if (preference instanceof IntPreference) {
			return ((IntPreference) preference).getModeValue(appMode);
		}
		return defValue;
	}

	@Override
	public long getLong(String key, long defValue) {
		OsmandPreference<?> preference = osmandSettings.getPreference(key);
		if (preference instanceof LongPreference) {
			return ((LongPreference) preference).getModeValue(appMode);
		}
		return defValue;
	}

	@Override
	public float getFloat(String key, float defValue) {
		OsmandPreference<?> preference = osmandSettings.getPreference(key);
		if (preference instanceof FloatPreference) {
			return ((FloatPreference) preference).getModeValue(appMode);
		}
		return defValue;
	}

	@Override
	public boolean getBoolean(String key, boolean defValue) {
		OsmandPreference<?> preference = osmandSettings.getPreference(key);
		if (preference instanceof BooleanPreference) {
			return ((BooleanPreference) preference).getModeValue(appMode);
		}
		return defValue;
	}

	@Nullable
	public Object getValue(String key, Object defValue) {
		OsmandPreference<?> preference = osmandSettings.getPreference(key);
		if (preference != null) {
			return preference.getModeValue(appMode);
		}
		return defValue;
	}
}

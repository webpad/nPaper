/*
 * Copyright (C) 2004-2015 FBReader.ORG Limited <contact@fbreader.org>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

#ifndef __OEBPLUGIN_H__
#define __OEBPLUGIN_H__

#include "../FormatPlugin.h"

class OEBPlugin : public FormatPlugin {

public:
	static ZLFile opfFile(const ZLFile &oebFile);
	static ZLFile epubFile(const ZLFile &oebFile);

public:
	~OEBPlugin();
	bool providesMetainfo() const;
	const std::string supportedFileType() const;
	bool readMetainfo(Book &book) const;
	virtual std::vector<shared_ptr<FileEncryptionInfo> > readEncryptionInfos(Book &book) const;
	bool readUids(Book &book) const;
	bool readLanguageAndEncoding(Book &book) const;
	bool readModel(BookModel &model) const;
	int readingPluginProgress(BookModel &model, bool isRunning) const;
	shared_ptr<const ZLImage> coverImage(const ZLFile &file) const;
};

#endif /* __OEBPLUGIN_H__ */
